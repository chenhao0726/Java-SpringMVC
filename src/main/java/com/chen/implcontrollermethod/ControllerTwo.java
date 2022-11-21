package com.chen.implcontrollermethod;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerTwo implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name + "===>" + password);

        request.setAttribute("msg", "实现控制器的第二种方式：实现HttpRequestHandler接口");
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
