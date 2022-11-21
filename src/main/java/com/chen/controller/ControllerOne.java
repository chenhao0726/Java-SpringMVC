package com.chen.controller;

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
        modelAndView.addObject("msg","第一个Controller");
        modelAndView.setViewName("/WEB-INF/views/index.jsp");
        return modelAndView;
    }
}
