package com.saibo.controller;

import com.saibo.base.BaseController;
import com.saibo.model.User;
import com.saibo.service.UserService;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/search")
    public String list(){
        return "search";
    }
    @RequestMapping("find/search")
    @ResponseBody
    public Object find(HttpServletRequest request){
        List<User> userList = new ArrayList<>();
        String value = request.getParameter("value");
        if (value==""){
           return "";
        }else {
            userList = userService.likeName(value);
        }

        return success(userList);
    }
}
