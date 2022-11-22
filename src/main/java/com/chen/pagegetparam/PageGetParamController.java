package com.chen.pagegetparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 向页面传递参数
 */
@Controller
public class PageGetParamController {

    // 页面获取参数的第一种方式 ModelAndView向前端传递参数
    @RequestMapping("/pageGetParam01")
    public ModelAndView pageGetParam01(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data",new User("Tom", 23) );
        modelAndView.addObject("datas", Arrays.asList(new User("Jack", 20),new User("Marry", 19)));
        modelAndView.setViewName("pageGetParam");
        return modelAndView;
    }

    // 向页面传递参数的方式二:通过HttpServletRequest传递
    @RequestMapping("/pageGetParam02")
    public void pageGetParam02(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("data",new User("Tom", 23) );
        request.setAttribute("datas", Arrays.asList(new User("Jack", 20),new User("Marry", 19)));
        request.getRequestDispatcher("/WEB-INF/views/pageGetParam.jsp").forward(request,response);
    }

    // 向页面传递参数的方式三: 通过model返回数据 @TODO 常用
    @RequestMapping("/pageGetParam03")
    public String pageGetParam03(Model model){
        model.addAttribute("data",new User("Tome", 23) );
        model.addAttribute("datas", Arrays.asList(new User("Jack", 20),new User("Marry", 19)));
        return "pageGetParam";
    }
}
