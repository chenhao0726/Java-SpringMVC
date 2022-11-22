package com.chen.json;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class JsonController {

    @RequestMapping("/json")
    @ResponseBody
    public User json() {
        Date date = new Date();
        System.out.println("时间：" + date);
        User tom = new User("Tom", "123456", 1, date);
        return tom;
    }
    @RequestMapping("/json02")
    @ResponseBody
    public ArrayList<User> jsonArrayList() {
        Date date = new Date();
        System.out.println("时间：" + date);
        User tom = new User("Tom", "123456", 1, date);
        User jack = new User("Jack", "123456", 1, date);
        ArrayList<User> objects = new ArrayList<>();
        objects.add(tom);
        objects.add(jack);
        return objects;
    }


    @RequestMapping(value = "/json03",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody User user, HttpSession session) {

        System.out.println(user);
        return "add";
    }

}
