package Dao;

import Entity.Blogger;

/**
 * Created by lenovo on 2018/5/14.
 */
public interface BloggerDao {

//    查询博主信息
    Blogger getBloggerData();

//    通过用户名查询博主信息
    Blogger getBloggerByName(String name);

//    更新博主信息
    Integer updateBlogger(Blogger blogger);
}
