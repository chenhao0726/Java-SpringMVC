package com.chen.implcontrollermethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/controller")
public class ControllerFour {

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("新增");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name + "===>" + password);

        // 返回页面并携带参数
        request.setAttribute("msg", "实现控制器的第三种方式：注解");
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }

    @RequestMapping("/delete")
    public ModelAndView delete() {
        System.out.println("删除");
        return new ModelAndView("/WEB-INF/views/index.jsp","msg","实现控制器的第三种方式：注解(返回ModelAndView)");
    }
}
