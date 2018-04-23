package Controllers.admin;

import Entity.BlogType;
import Entity.PageBean;
import Service.BlogTypeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.json.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import util.ResponseUtil;

@Controller
@RequestMapping(value = "/admin/blogType")
public class BlogTypeController {
    @Resource
    private BlogTypeService blogTypeService;

    @RequestMapping("/list")
    public String listBlogType(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
            HttpServletResponse response) throws Exception {

        //定义分页bean
        PageBean<BlogType> pageBean = new PageBean<BlogType>(Integer.parseInt(page)
                ,Integer.parseInt(rows));
        //拿到分页结果已经记录总数的pageBean
        pageBean = blogTypeService.listByPage(pageBean);
        //使用阿里巴巴的fastJson创建JSONObject
        JSONObject result = new JSONObject();
        //通过fastJson序列化list为jsonArray
        String jsonArray = JSON.toJSONString(pageBean.getResult());
        JSONArray array = JSONArray.parseArray(jsonArray);
        //将序列化结果放入json对象中
        result.put("rows", array);
        result.put("total", pageBean.getTotal());

        //使用自定义工具类向response中写入数据
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Long add(){
        return blogTypeService.all();
    }

    //添加和更新博客
    @RequestMapping("/save")
    public String save(BlogType blogType,HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if(blogType.getId() == null){
            resultTotal = blogTypeService.addBlogType(blogType);
        } else{
            resultTotal = blogTypeService.updateBlogType(blogType);
        }

        JSONObject result = new JSONObject();
        if(resultTotal > 0){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    //删除类别信息
    @RequestMapping("/delete")
    public String deleteBlog(@RequestParam(value = "ids",required = false) String ids, HttpServletResponse response) throws Exception{
        //分割字符串得到 id 数组
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for(int i = 0;i<idsStr.length;i++){
            int id = Integer.parseInt(idsStr[i]);
            //其实在这里我们要判断该博客类别下面是否有博客 如果有就禁止删除博客类别 ，等我们完成博客对应的操作再来完善
            blogTypeService.deleteBlogType(id);

        }
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }
}
