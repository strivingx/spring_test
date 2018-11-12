
import com.yyy.SsmApplication;
import com.yyy.User;
import com.yyy.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SsmApplication.class)
public class UserTest {

    public static void println(List list) {
        println(list, "");
    }

    public static void println(List list, String msg) {
        System.out.println(msg);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    @Autowired
    private SqlSession sqlSession;

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
        Assert.assertEquals("更新名字", user.getName());

        System.out.println(user);
        userDao.delete(user.getId());

        user = userDao.getById(user.getId());
        Assert.assertEquals(user, null);
        System.out.println(user);
    }

    @Test
    public void testCache() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println( userDao.getById(3));
        userDao.getById(24);

        userDao.getById(23);
        userDao.getById(24);
    }

}
