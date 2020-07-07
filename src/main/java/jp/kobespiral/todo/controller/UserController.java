package jp.kobespiral.todo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobespiral.todo.entity.User;
import jp.kobespiral.todo.form.UserForm;
import jp.kobespiral.todo.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService us;

    @PostMapping("/users")
    public String addUser(@Validated UserForm form, Model model){
        User u = new User();
        u.setUid(form.getUid());
        u.setName(form.getName());
        u.setCreatedAt(new Date());
        User user = us.createUser(u);
        model.addAttribute("uid", user.getUid());
        model.addAttribute("name", user.getName());
        model.addAttribute("createdAt", user.getCreatedAt());
        return "success";
    }

    // @GetMapping("/user/uid")
    // public String showUser(String uid,Model model){
    //     User u = us.getUserByUid(uid);
    //     model.addAttribute("ulist", u);
    //     return "userinfo";
    // }

    @GetMapping("/users")
    public String showAllUser(Model model){
        List<User> list = us.getAllUser();
        model.addAttribute("ulist", list);
        return "alluserlist";
    }

    
    
    // /user POST: addUser(UserForm)
    // /user/uid GET: showUser(uid)
    // /user GET: showAllUser()
}