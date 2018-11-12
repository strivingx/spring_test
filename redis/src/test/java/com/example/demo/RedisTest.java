package com.example.demo;

import com.yyy.dao.User;
import com.yyy.dao.UserDao;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Resource
	private UserDao userDao;

	@Test
	public void test() {//更改在redis里面查看key编码问题
		RedisSerializer redisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		String key = "aabbcc";
		redisTemplate.opsForValue().set(key, "test");
		System.out.println(redisTemplate.opsForValue().get(key));
		assertEquals("test", redisTemplate.opsForValue().get(key));

		redisTemplate.delete(key);
		assertEquals(null, redisTemplate.opsForValue().get(key));
	}

	@Test
	public void test1() {//更改在redis里面查看key编码问题
		User user = new User();
		user.setId(1);
		//userDao.insert(user);
	}

}
