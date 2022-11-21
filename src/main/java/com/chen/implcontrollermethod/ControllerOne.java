package com.chen.implcontrollermethod;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerOne implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name + "===>" + password);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","实现控制的第一种方式：实现Controller接口");
        modelAndView.setViewName("/WEB-INF/views/index.jsp");
        return modelAndView;
//        return new ModelAndView("/WEB-INF/views/index.jsp", "msg", "实现控制的第一种方式：实现Controller接口")
    }
}
