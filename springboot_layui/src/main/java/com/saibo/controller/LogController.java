package com.saibo.controller;

import com.saibo.base.BaseController;

import com.saibo.base.ResultData;
import com.saibo.model.Log;
import com.saibo.model.User;
import com.saibo.service.LogService;
import com.saibo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    @Resource
    private LogService logService ;
    @Resource
    private UserService userService ;

    @RequestMapping("/userLog")
    @ResponseBody
    public Object userLog(Log log) {
        int count = logService.getCount(log);
        List<Log>  logList = logService.logList(log);

        return success(logList,count) ;
    }
    @RequestMapping("/logList")
    public  String  logList(){
        return "sysLogList";
    }

    @RequestMapping("/ygLog")
    public  String  ygLog(Model model,String userId){
        Long userId1 = Long.parseLong(userId);
        User user = userService.getUserById(userId1);
        model.addAttribute("name",user.getName());
        model.addAttribute("userId",userId);
        return "staffList";
    }

    @RequestMapping("/wrtLog")
    public  String  wrtLog(){
        return "wrtLog";
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping("/addLog")
    public String addUser(Model model, String userId) {
        model.addAttribute("userId",userId);
        return "addLog";
    }

    /**
     * 保存用户
     *
     * @param
     * @return
     */
    @RequestMapping("/saveLog")
    @ResponseBody
    public Object saveLog(HttpServletRequest request, Log log) {
          log.setCreateTime(new Date());
          int i  = logService.saveLog(log);
          if (i>0){
              return success("保存成功！");
          }else {
              return fail("保存失败");
          }

    }
    @RequestMapping("/myLog")
    public String myLog(Model model,String userId) {
        Long userId1 = Long.parseLong(userId);
        User user = userService.getUserById(userId1);
        model.addAttribute("name",user.getName());
        model.addAttribute("userId",userId);
        return "myLog";
    }

//    @RequestMapping("/myWrtLog")
//    @ResponseBody
//    public Object myWrtLog(String userId) {
//        List<Log>  logList = logService.myWrtLog(userId);
//        return success(logList) ;
//
//    }


}
