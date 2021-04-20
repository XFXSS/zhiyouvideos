package com.zhiyou.video.controller;

import com.zhiyou.video.model.ResultObject;
import com.zhiyou.video.model.User;
import com.zhiyou.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/front/user")
public class UserController {

    @Autowired
    private UserService userService;

    /** 登录 */
    @RequestMapping("/login.do")
    public String login(Model model,String email, String password) {
            User user = userService.findUserByLogin(email,password);
            if (user != null || "".equals(user)) {
                System.out.println("登录成功");
                model.addAttribute("user",user);
                return "/front/user/index";
            }
            System.out.println("登录失败");
            return "/front/video/index";
        }
    @RequestMapping("/logins.do")
    @ResponseBody
    public ResultObject logins(@RequestBody String email, String password) {
            User user = userService.findUserByLogin(email,password);
            if (user != null || "".equals(user)) {
                return new ResultObject(200,"可以登录",user);
            }
            return new ResultObject(500,"用户名或密码错误!!!");
        }
    /** 注册 */
    @RequestMapping("/regist.do")
    public String regist(String email,String password,String pswAgain) {
        if (password.equals(pswAgain)) {
            if (password != null && email != null) {
                userService.findUserByRegist(email,password);
                return "/front/video/index";
            }
            return "/front/video/index";
        }
        return "/front/video/index";
    }
    /** 更改资料 */
    @RequestMapping("/profile.do")
    public String profile(Model model,String nick_name) {
        User user = userService.findUserByprofile(nick_name);
        model.addAttribute("user",user);
        return "/front/user/profile";
    }
    /** 更改头像 */
    @RequestMapping("/avatar.do")
    public String avatar(Model model,String nick_name) {
        User user = userService.findUserByavatar(nick_name);
        model.addAttribute("user",user);
        return "/front/user/avatar";
    }

    /** 更改头像2 */
    @RequestMapping("/avatars.do")
    @ResponseBody
    public ResultObject avatars(HttpServletRequest request) throws IOException {
        // 将请求强转为[多部件请求对象]
        MultipartHttpServletRequest mhReq = (MultipartHttpServletRequest) request;

        // 获得文件对象,此处要与前端页面的name属性值保持一致
        MultipartFile file = mhReq.getFile("file");
        String filename = this.createFileName(file.getOriginalFilename());
        System.out.println("文件名: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + filename);

        // 上传至服务器路径
        ServletContext servletContext = request.getServletContext();
        // 获得文件在服务器的项目上的真实路径
        String realPath = servletContext.getRealPath("/upload");
        File parent = new File(realPath);
        if (!parent.exists()) {
            parent.mkdir();
        }

        File targetFile = new File(parent, filename);
        // 开始上传
        file.transferTo(targetFile);
        System.out.println("上传完毕");
        System.out.println("====================/upload/" + filename);
        return new ResultObject(200, "成功", "/upload/" + filename);
    }
    /** 文件上传 生成文件名 */
    public String createFileName(String oldname) {
        // 获得老文件的后缀
        String[] split = oldname.split("\\.");
        String suffix = split[split.length-1];

        // 生成随机数
        String uuid = UUID.randomUUID().toString();
        return uuid+"."+suffix;
    }
    @RequestMapping("/avatartwo.do")
    public String avatartwo(String head_url,String nick_name) {
        System.out.println(head_url+"===================="+nick_name);
        userService.findUserByavatartwo(head_url,nick_name);
        return "/front/user/avatar";
    }
    @RequestMapping("/password.do")
    public String password(Model model,String nick_name) {
        User user = userService.findUserBypassword(nick_name);
        model.addAttribute("user",user);
        return "/front/user/password";
    }
    @RequestMapping("/passwords.do")
    public String passwords(String password,String newPasswords,String newPassword) {
        if (newPassword.equals(newPasswords)) {
            userService.findUserBypasswords(password,newPasswords);
            return "/front/user/index";
        }
        return "";
    }

    @RequestMapping("/profile2.do")
    public String profiletwo(Model model,User user) {
        System.out.println("================="+user);
        userService.findUserByprofiletwo(user);
        return "/front/user/index";
    }
}
