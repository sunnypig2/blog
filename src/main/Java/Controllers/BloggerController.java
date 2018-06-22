package Controllers;

import Entity.Blogger;
import Service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.MD5Util;

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

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/loginIn" ,method = RequestMethod.POST)
    public String loginIn(Blogger blogger, HttpServletRequest request){
        System.out.println(blogger.toString());
        //获取登录实体
        Subject subject = SecurityUtils.getSubject();
        //获取加密后密码
        String password = MD5Util.md5(blogger.getPassWord(),"xp");
        //后去用户密码登录token
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(),password);
        try{
            subject.login(token);
            if(subject.hasRole("admin")){
                return "redirect:/static/admin/common/menu.jsp";
            }else{
                return "redirect:/index.jsp";

            }
        }catch(AuthenticationException e){
            request.setAttribute("blogger",blogger);
            request.setAttribute("errorInfo","用户名或密码错误");
            return "login";
        }
   }
}
