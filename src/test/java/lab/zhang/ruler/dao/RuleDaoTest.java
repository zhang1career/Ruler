package lab.zhang.ruler.dao;

import lab.zhang.ruler.pojo.Rule;
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

import static org.junit.Assert.assertNotNull;

public class RuleDaoTest {
    private SqlSession sqlSession;
    private RuleDao target;

    @Before
    public void setUp() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        target = sqlSession.getMapper(RuleDao.class);
    }

    @After
    public void cleanUp() {
        sqlSession.close();
    }

    @Test
    public void test_selectAll() {
        List<Rule> rules = target.selectAll();
        assertNotNull(rules);
        System.out.println(rules);
    }

    @Test
    public void test_selectById() {
        Rule rule = target.selectById(1);
        assertNotNull(rule);
        System.out.println(rule);
    }

    @Test
    public void test_insert() {
        Rule rule = new Rule();
        rule.setCond("hahaha");
        target.insert(rule);
    }

    @Test
    public void test_update() {
        Rule rule = new Rule();
        rule.setId(3);
        rule.setCond("qwer");
        target.update(rule);
    }

    @Test
    public void test_delete() {
        target.delete(3);
    }
}
