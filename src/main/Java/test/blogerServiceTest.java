package test;

import Service.BloggerService;
import Service.impl.BloggerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by lenovo on 2018/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml",
        "classpath:spring-mybatis.xml","classpath:spring-mybatis.xml"})
public class blogerServiceTest {
    @Autowired
    BloggerService bloggerService;

    @Test
    public void testbloggerService(){
        System.out.println(bloggerService.getBloggerByName("test"));
    }
}
