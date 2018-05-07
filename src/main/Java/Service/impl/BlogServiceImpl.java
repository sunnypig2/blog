package Service.impl;

import Dao.BlogDao;
import Entity.Blog;
import Entity.PageBean;
import Service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/5/2.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    public List<Blog> listBlog(Map<String, Object> map) {
        return blogDao.listBlog(map);

    }

    public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean) {
        Map<String,Object> map = new HashMap<String, Object>();
        //设置查询条件
        map.put("title",title);
        //总记录放入pagaBean
        pageBean.setTotal(blogDao.getTotal(map));
        map.put("start",pageBean.getStart());
        map.put("end",pageBean.getEnd());
        //把分页结果放入pageBean
        pageBean.setResult(blogDao.listBlog(map));
        return pageBean;

    }

    public Integer getBlogByTypeId(Integer typeId) {
        return blogDao.getBlogByTypeId(typeId);
    }

    public Integer saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    public Integer updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    public Integer deleteBlog(Integer id) {
        return blogDao.deleteBlog(id);
    }

    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

    public long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }
}
