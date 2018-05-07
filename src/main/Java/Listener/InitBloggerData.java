package Listener;

import Entity.BlogType;
import Service.BlogTypeService;
import Service.impl.BlogTypeServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

@Component
/**
 * Created by lenovo on 2018/5/5.
 */
public class InitBloggerData implements ServletContextListener , ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //先获取servlet上下文
        ServletContext application = servletContextEvent.getServletContext();
//        System.out.println(application);
        //同上，获取博客类别信息service
        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
//        System.out.println(blogTypeList);
        application.setAttribute("blogTypeList",blogTypeList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }
}
