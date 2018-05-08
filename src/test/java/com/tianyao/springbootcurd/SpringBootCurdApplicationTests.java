package com.tianyao.springbootcurd;

import com.tianyao.springbootcurd.entities.GuideInfo;
import com.tianyao.springbootcurd.mapper.TestMappper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


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

}
