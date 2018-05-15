package Controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2018/5/15.
 * 跳转后台管理主页面测试类
 */
@Controller
@RequestMapping(value="/admin")
public class MainAdminController {

    @RequestMapping(value="/menu")
    public String toMenuPage(){
        return "/static/admin/common/menu";
    }
}
