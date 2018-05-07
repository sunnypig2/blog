package Dao;

import Entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/4/25.
 */
public interface BlogDao {

    //增加博客
    public Integer saveBlog(Blog blog );
    //删除博客
    public Integer deleteBlog(Integer id);
    //修改博客
    public Integer updateBlog(Blog blog);
    //根据ID获取博客
    public Blog getById(Integer id);
    //获取记录总数
    public Integer getTotal(Map<String,Object> map);
    //根据博客类型得ID查询该类型下的博客数量
    public Integer getBlogByTypeId(Integer typeId);

    //分页查询博客
    public List<Blog> listBlog(Map<String,Object> map);
}
