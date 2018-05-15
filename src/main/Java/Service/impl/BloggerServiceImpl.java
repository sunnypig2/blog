package Service.impl;

import Dao.BloggerDao;
import Entity.Blogger;
import Service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/5/14.
 */

@Service
public class BloggerServiceImpl implements BloggerService {
    @Resource
    private BloggerDao bloggerDao;

    public Blogger getBloggerData() {
        return bloggerDao.getBloggerData();
    }

    public Blogger getBloggerByName(String username) {
        return bloggerDao.getBloggerByName(username);
    }

    public Integer updateBlogger(Blogger blogger) {
        return bloggerDao.updateBlogger(blogger);
    }
}
