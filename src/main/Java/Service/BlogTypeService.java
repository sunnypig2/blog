package Service;

import Entity.BlogType;
import Entity.PageBean;

import java.util.List;

public interface BlogTypeService {

    //分页查询
    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);

    //
    Long all();

    //添加博客类别
    public Integer addBlogType(BlogType blogType);
    // 更新博客类别
    public Integer updateBlogType(BlogType blogType);
    //删除博客类别
    public Integer deleteBlogType(Integer id);

    List<BlogType> getBlogTypeData();

}
