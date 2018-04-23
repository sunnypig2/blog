package Service.impl;

import Dao.BlogTypeDao;
import Entity.BlogType;
import Entity.PageBean;
import org.springframework.stereotype.Service;
import Service.BlogTypeService;
import javax.annotation.Resource;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
        //查询分页结果
        pageBean.setResult(blogTypeDao.listByPage(pageBean.getStart(),pageBean.getEnd()));

        //查询记录总数
        pageBean.setTotal(blogTypeDao.getTotal());
        return pageBean;
    }

    public Long all(){
        return blogTypeDao.getTotal();
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeDao.addBlogType(blogType);
    }

    public Integer updateBlogType(BlogType blogType) {
        return blogTypeDao.updateBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id) {
        return blogTypeDao.deleteBlogType(id);
    }
}
