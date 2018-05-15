package Service;

import Entity.Blogger;

/**
 * Created by lenovo on 2018/5/14.
 */
public interface BloggerService {

    Blogger getBloggerData();

    Blogger getBloggerByName(String username);

    Integer updateBlogger(Blogger blogger);
}
