
import com.yyy.UserDao;
import com.yyy.UserMapper;
import com.yyy.mapper.User1Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest1 {
    public static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        try {
            println(sqlSession.getMapper(UserMapper.class).getList(), "");
            println(sqlSession.getMapper(User1Mapper.class).getList(), "");
            println(sqlSession.getMapper(UserDao.class).getList(), "annotation");
        } finally {
            sqlSession.close();
        }
    }

    public static void println(List list) {
        println(list, "");
    }

    public static void println(List list,String msg) {
        System.out.println(msg);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }


    @Test
    public void testUserAnnotation(){
       /* UserDao userDao = sqlSession.getMapper(UserDao.class);
        println(userDao.getList());*/
    }

    SqlSession sqlSession;
    @Before
    public void before(){
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
