package com.tianyao.springbootcurd;

import com.tianyao.springbootcurd.dao.TestUserDao;
import com.tianyao.springbootcurd.entities.GuideInfo;
import com.tianyao.springbootcurd.entities.TestUser;
import com.tianyao.springbootcurd.mapper.TestMappper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCurdApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
    DataSource dataSource;

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
    TestMappper testMappper;

	@Autowired
    TestUserDao testUserDao;


	@Test
	public void contextLoads() throws Exception{
		logger.debug("tianyao-test:"+dataSource.getConnection());

    }
	@Test
	public void contextLoads2() throws Exception{
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT  *  FROM supply_guideinfo");
      //  jdbcTemplate.queryForMap("");
        logger.debug("tianyao-test:"+maps);
    }

    @Test
    public  void test(){
        Map<String, Object> all = testMappper.getAll();
        logger.info(all.toString());
    }

    @Test
    public  void testGetGuideInfo(){
        GuideInfo guideInfo = testMappper.getGuideInfo();
        logger.info(guideInfo.toString());
    }
    @Test
    public  void testTestUserDao(){
        TestUser testUser = new TestUser();
        testUser.setEmail("tianyao@163.com");
        testUser.setLastName("tianyao2");
        testUserDao.save(testUser);

        List<TestUser> all = testUserDao.findAll();
        logger.info(all.toString());

    }

    @Test
    public  void testTestUserDao2(){
        Optional<TestUser> byId = testUserDao.findById(1);

        logger.info(byId.get().toString());

    }

    @Test
    public  void testTestUserDao3(){
        testUserDao.deleteById(2);
        logger.info("删除成功！！！");
    }

    @Test
    public  void testTestUserDao4(){
        TestUser user = new TestUser();
        user.setId(3);
        testUserDao.delete(user);
        logger.info("删除成功！！！");
    }
    @Test
    public  void testTestUserDao5(){
        //TestUser tianyao = testUserDao.getMyUser("tianyao");
        Map<String,Object> tianyao = testUserDao.getMyUser("tianyao");
        logger.info(tianyao.toString());
    }

    @Test
    public  void testTestUserDao6(){
        TestUser tianyao = testUserDao.getMyUser2("tianyao");
        logger.info(tianyao.toString());
    }




}
