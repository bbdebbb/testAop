package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class TestMybatis {
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory sessionFactory;
    @Before
    public void testbefore() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        builder = new SqlSessionFactoryBuilder();
        sessionFactory = builder.build(reader);
    }

    @Test
    public void test01() {
        SqlSession session = sessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<Integer> integers = userDao.countUser();
    }
}
