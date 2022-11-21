package com.chen.allannotation;


import com.chen.allannotation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annotation")
public class AllAnnotationController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/save")
    public ModelAndView save() {
        System.out.println("Controller控制器注解");
        iUserService.save();
        return new ModelAndView("/WEB-INF/views/index.jsp", "msg", "全注解开发");
    }

}
