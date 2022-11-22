package com.chen.getparammethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取参数的四种方式
 */
@Controller
public class GetParamMethodController {

    /**
     * 方式一 通过HttpServletRequest获取参数
     */
    @RequestMapping("/method01")
    public void method01(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        // 获取参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        // 手动转换类型并封装
        Employee employee = new Employee(Long.parseLong(id), name);
        // @TODO 业务处理
        // 响应数据
        response.getWriter().println("获取参数方式一：HttpServletRequest");
    }

    /**
     * 获取参数方式二，直接通过参数名获取
     * 如果参数名不同使用@RequestParam("")指定
     * @param id
     * @param name
     * @param response
     * @throws IOException
     */
    @RequestMapping("/method02")
    public void method02(Long id,@RequestParam("name") String names, HttpServletResponse response) throws IOException {
        Employee employee = new Employee(id, names);
        // @TODO 业务处理
        // 响应数据
        response.getWriter().println("获取参数方式二：直接通过参数名获取");
    }

    /**
     * 获取参数方式三：通过对象直接获取
     * @param employee
     * @param response
     * @throws IOException
     */
    @RequestMapping("/method03")
    public void method03(Employee employee,HttpServletResponse response) throws IOException {
        System.out.println(employee);
        // @TODO 业务处理
        // 给页面响应数据
        response.getWriter().println("获取参数方式三：通过对象获取");
    }

    /**
     * 获取参数方式三：从url中获取
     * @param id
     * @param name
     * @param response
     * @throws IOException
     */
    @RequestMapping("/method04/{id}/{name}")
    public void method04(@PathVariable("id") Long id,@PathVariable("name") String name,HttpServletResponse response) throws IOException {
        // 封装数据
        Employee employee = new Employee(id, name);
        // @TODO 业务处理
        // 响应数据
        response.getWriter().println("获取参数方式三：从url中获取");
    }

}
