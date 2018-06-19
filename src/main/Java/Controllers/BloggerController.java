package Controllers;

import Entity.Blogger;
import Service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 博主控制层前台 不需要shiro认证
 */
@Controller
@RequestMapping(value="/blog")
public class BloggerController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping(value = "/")
    public String login(HttpServletRequest request){
        return "login";
    }
    
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String login(Blogger blogger, HttpServletRequest request){
        System.out.println(blogger);
        return "redirect:/static/admin/common/menu.jsp";
   }
}
