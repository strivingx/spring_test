package com.example.demo;

import com.yyy.domain.User;
import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.api.config.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testJava() throws Exception {
		// 配置真实数据源
		Map<String, DataSource> dataSourceMap = new HashMap<>();

		// 配置第一个数据源
		BasicDataSource dataSource1 = new BasicDataSource();
		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://localhost:3306/ds_0");
		dataSource1.setUsername("root");
		dataSource1.setPassword("root");
		dataSourceMap.put("ds0", dataSource1);

		// 配置第二个数据源
		BasicDataSource dataSource2 = new BasicDataSource();
		dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource2.setUrl("jdbc:mysql://localhost:3306/ds_1");
		dataSource2.setUsername("root");
		dataSource2.setPassword("root");
		dataSourceMap.put("ds1", dataSource2);

		// 配置Order表规则
		TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
		orderTableRuleConfig.setLogicTable("t_user");
		orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_user${0..1}");

		// 配置分库 + 分表策略
		orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "ds${id % 2}"));
		orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "t_user${id % 2}"));

		// 配置分片规则
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

		// 省略配置order_item表规则...
		// ...

		// 获取数据源对象
		DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentHashMap(), new Properties());
		insertValue(dataSource);
	}

	@Test
	public void testYml() throws Exception {
		File yamlFile = new File(this.getClass().getResource("/sharding.yml").getFile());
		System.out.println(FileUtils.readFileToString(yamlFile));
		DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(yamlFile);

		insertValue(dataSource);
	}

	@Resource
	private DataSource dataSource;

	@Test
	public void testSpring() throws Exception {
		insertValue(dataSource);
	}

	public void insertValue(DataSource dataSource) throws Exception {
		User user = new User();
		user.setId(new Random().nextInt());
		user.setName("www");
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		PreparedStatement ps = connection.prepareStatement("insert into t_user (id, name, sex) values(" + user.getId() + ", '" + user.getName() + "', 0)");
		ps.executeUpdate();
	}

}
