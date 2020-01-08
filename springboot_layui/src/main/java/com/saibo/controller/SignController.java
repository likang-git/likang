package com.saibo.controller;

import com.saibo.base.BaseController;
import com.saibo.base.CommonUtil;
import com.saibo.model.Sign;
import com.saibo.service.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sign")
public class SignController extends BaseController {
    @Resource
    private SignService signService ;

    @RequestMapping("/clock")
    @ResponseBody
    public  Object clock(Sign sign) {
        if (sign.getSignOut()!=null){
           return success("今天签到已完成请勿重复签到！",1);
        }
        if (sign.getId() != null && sign.getId() != "") {
            sign.setSignOut(new Date());
            int i = signService.updateSign(sign);
            Sign sign1 = signService.getSign(sign.getId());
            if (i > 0) {
                return success(sign1,"下班打卡成功！");
            } else {
                return fail("打卡失败");
            }
        } else {
            sign.setSignIn(new Date());
            String id = CommonUtil.uuid();
            sign.setId(id);
            int i = signService.saveSign(sign);
            Sign sign1 = signService.getSign(id);
            if (i > 0) {
                return success(sign1, "上班打卡成功！");
            } else {
                return fail("打卡失败");
            }
        }
    }
    @RequestMapping("/check")
    @ResponseBody
    public Object  check(Sign sign){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);

        sign.setNewTime(dateString);
        Sign sign1 =  signService.check(sign);
        if (sign1==null){
            return success(1,1);
        }else {
            if (sign1.getSignOut()==null){
                return success(sign1,200);
            }else {
                return success(sign1,1);
            }

        }
    }
    @RequestMapping("/grSign")
    public  String  grSign(Model model ,String id){
        model.addAttribute("userId",id);
        return "perSign";
    }
    @RequestMapping("/geSign")
    @ResponseBody
    public  Object  geSign(String userId){
        Long userId1 = Long.parseLong(userId);
       List<Sign> signList = signService.geSign(userId1);
       return success(signList);
    }
}
