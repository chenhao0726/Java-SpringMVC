package com.chen.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 配置了视图解析器
 * 返回页面的方式
 */
@Controller
public class ViewResolverController {

    /**
     * 返回方式一：ModelAndView
     * @return
     */
    @RequestMapping("/viewResolver01")
    public ModelAndView viewResolver01() {
        return new ModelAndView("viewResolver");
    }

    /**
     * 返回方式二：返回字符串，通过视图解析自动拼接前缀和后缀
     * @return
     */
    @RequestMapping("/viewResolver02")
    public String viewResolver02() {
        return "viewResolver";
    }

    /**
     * 方式三：指定跳转，重定向
     * @return
     */
    @RequestMapping("/viewResolver03")
    public String viewResolver03() {
        return "redirect:/WEB-INF/views/viewResolver.jsp";
    }

    /**
     * 方式三：指定跳转，请求转发
     * @return
     */
    @RequestMapping("/viewResolver004")
    public String viewResolver004() {
        return "forword:/WEB-INF/views/viewResolver.jsp";
    }

}
