
import com.yyy.User;
import com.yyy.UserDao;
import com.yyy.UserMapper;
import com.yyy.mapper.User1Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    public static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
        return sqlSessionFactory.openSession();
    }

    public static void println(List list) {
        println(list, "");
    }

    public static void println(List list, String msg) {
        System.out.println(msg);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    @Test
    public void testUserAnnotation() {
        String name = "有意义";
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 添加
        userDao.insert(name);
        User user = userDao.getByName(name);
        Assert.assertNotEquals(user, null);
        Assert.assertEquals(user.getName(), name);
        int id = user.getId();
        System.out.println(user);

        userDao.update(id, "更新名字");
        user = userDao.getById(user.getId());
        Assert.assertEquals(user.getName(), "更新名字");

        System.out.println(user);
        userDao.delete(user.getId());

        user = userDao.getById(user.getId());
        Assert.assertEquals(user, null);
        System.out.println(user);
    }

    @Test
    public void testCache() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.getById(24);
        userDao.getById(24);

        userDao.getById(23);
        userDao.getById(24);
    }

    SqlSession sqlSession;

    @Before
    public void before() {
        try {
            sqlSession = getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        if (sqlSession != null) sqlSession.close();
    }
}
