package Controllers.admin;

import Entity.Blog;
import Entity.PageBean;
import Service.BlogService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2018/5/2.
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

    @Resource
    private BlogService blogService;

    //后台分页查询博客信息
    @RequestMapping("/listBlog")
    public String listBlog(String page, String rows, Blog s_blog, HttpServletResponse response) throws  Exception{
        PageBean<Blog> pageBean = new PageBean<Blog>(Integer.parseInt(page),Integer.parseInt(rows));
        pageBean = blogService.listBlog(s_blog.getTitle(),pageBean);

        JSONObject result = new JSONObject();
        //设置json序列化日期格式
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        //禁止对象循环引用
        //设置默认日期格式化
        String jsonStr = JSONObject.toJSONString(pageBean.getResult(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);

        //得到json数组
        JSONArray array = JSON.parseArray(jsonStr);
        //把结果放入json
        result.put("rows",array);
        result.put("total",pageBean.getTotal());
        //返回
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/save")
    public String saveBlog(Blog blog,HttpServletResponse response) throws Exception{
        int resultTotal =0;
        if(blog.getId() != null){
            //更新操作
            resultTotal = blogService.updateBlog(blog);

        }else{
            //添加操作
            resultTotal = blogService.saveBlog(blog);
        }
        JSONObject result = new JSONObject();
        if(resultTotal > 0){
            result.put("success",true);
        } else {
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/delete")
    public String deleteBlog(String ids,HttpServletResponse response) throws Exception{
        String[] idsStr = ids.split(",");
        System.out.println(idsStr);
        for(int i=0;i<idsStr.length;i++){
            int id = Integer.parseInt(idsStr[i]);
            //先删除博客所关联的评论 现在没有完成评论的功能 先注释
            //commentService.deleteCommentByBlogId(id);
            blogService.deleteBlog(id);
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping("/get")
    public String getById(String id,HttpServletResponse response) throws Exception{
        Blog blog = blogService.getById(Integer.parseInt(id));
        String jsonStr = JSONObject.toJSONString(blog);
        JSONObject result = JSONObject.parseObject(jsonStr);
        ResponseUtil.write(response,result);
        return  null;
    }
}
