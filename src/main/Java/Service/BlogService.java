package Service;

import Entity.Blog;
import Entity.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/5/2.
 */
public interface BlogService {
    //分页查询博客
    public List<Blog> listBlog(Map<String,Object> map);

    //分页查询博客
    public PageBean<Blog> listBlog(String title,PageBean<Blog> pageBean);

    //根据博客类型的id查询该类型下的博客数量
    public Integer getBlogByTypeId(Integer typeId);

    //添加博客
    public Integer saveBlog(Blog blog);

    //更新博客
    public Integer updateBlog(Blog blog);

    //通过ID删除博客
    public  Integer deleteBlog(Integer id);

    //通过ID获取博客
    public Blog getById(Integer id);

    long getTotal(Map<String,Object> map);

}
