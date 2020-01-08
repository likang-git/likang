package com.saibo.controller;

import com.alibaba.fastjson.JSON;
import com.saibo.base.BaseController;
import com.saibo.dao.UserDao;
import com.saibo.model.User;
import com.saibo.model.UserVo;
import com.saibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


    @Resource
    private UserService userService;

    /**
     * 跳转登陆界面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/managerList")
    public String managerList(){
        return "userList";
    }
    @RequestMapping("/userLogin")
    @ResponseBody
    public Object userLogin(HttpServletRequest request, User user) {
        User userLogin = userService.getUser(user.getUserName());
        if (userLogin != null) {
            if (userLogin.getPassword().equals(user.getPassword())) {

                HttpSession session = request.getSession();
                session.setAttribute("id", userLogin.getId());
                if (user.getUserName().equals("xtgly")){
                    return success("登陆成功",200);
                }
//                request.getSession().setAttribute("name",userLogin.getName());
                return success(userLogin,"登陆成功");
            } else {
                return fail("密码填写错误");
            }
        } else {
            return fail("用户不存在！");
        }
    }

    @RequestMapping("/managerUser")
    public String UserList() {

        return "userList";
    }

    @RequestMapping("/staffUser")
    public  String  staffUser(Model model,String id){
        Long id1 = Long.parseLong(id);
        User user = userService.getUserById(id1);
        model.addAttribute("name",user.getName());
        model.addAttribute("userId",id);
        return "staffList";
    }

    @RequestMapping("/userAll")
    @ResponseBody
    public Object all( UserVo  userVo ) {

        /**
         * 每页显示10条数据 从n页开始
         * n页数据为（n-1）*10+1条 至n*10条
         * limit
         * 起点0开始查询返回1条数据
         * SELECT * FROM saibo_user  limit 1 OFFSET 0;
         * SELECT * FROM saibo_user  limit 页面大小 OFFSET （n-1）*10;
         */
        /**分页实现
         * 1.数据总数
         * 2.页面大小 10（自定义）
         * 3.总页数   （程序自动计算）
         * 4.当前页（自定义）
         * 5.当前页的对象集合
         * 当前页pageIndex,页面大小pageSize
         */

        int count = userService.getCount(userVo);

        List<User>  userList = userService.queryUserList(userVo);

        return success(userList,count);
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser() {

        return "addUser";
    }

    /**
     * 保存用户
     *
     * @param
     * @return
     */
    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveManager(HttpServletRequest request, User user) {
        Long id = user.getId();
        if (StringUtils.isEmpty(id)) {
            User user1 = userService.getUser(user.getUserName());
            if (user1!=null){
                return success("账号重复请重新输入！",500);
            }
            int a = userService.saveUser(user);
            if (a > 0) {
                return success("新增成功");
            } else {
                return fail("操作失败");
            }
        } else {
            userService.updateUser(user);
            return success("更新成功");
        }
    }

    @RequestMapping("/getUserById")
    public Object getUserById(Model model, String id) {
//        Long id1 = Long.parseLong(id);
//        User user =  userService.getUserById(id1);
        model.addAttribute("id", id);
        return "addUser";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Object get(String id) {
        Long id1 = Long.parseLong(id);
        User user = userService.getUserById(id1);
        return user;
    }



    //
//    @RequestMapping("/add")
//    @ResponseBody
//    public Object add(User user){
//       int i =    userDao.addUser(user);
//       if (i>0){
//           return  "增加成功";
//       }
//       return "增加失败";
//    }
//
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Object delete(String id) {
        int i = userService.deleteUser(id);
        if (i > 0) {
            return success("删除成功！");
        }
        return fail("删除失败！");
    }

    @RequestMapping("/tuiLogin")
    public  String tuiLogin(HttpServletRequest request){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "login";
    }

//    @RequestMapping("/getUser")
//    @ResponseBody
//    public Object getUser(String id){
//        Long id1 = Long.parseLong(id);
//        User user =  userDao.getUserById(id1);
//        if (user!=null){
//            return  user;
//        }
//        return "服务器出问题";
//    }
//    @RequestMapping("/updateUser")
//    @ResponseBody
//    public Object updateUser(User user){
//
//        int  i =  userDao.updateUser(user);
//        if (i>0){
//            return  "修改成功";
//        }
//        return "服务器出问题";
//    }
//
//    @RequestMapping("/userView")
//    public ModelAndView  view(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/saibo/userView/userList");
//        return mv;
//    }

}
