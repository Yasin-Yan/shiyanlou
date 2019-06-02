package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

@Controller
public class UserController {

    // ����ע��ҳ��
    @RequestMapping(value = "/registerform")
    public String registerform(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // ע���������Ӧ����
    @RequestMapping(value = "/register")
    public String register(@Valid  @ModelAttribute("user") User user, Errors errors,Model model) {
        if(errors.hasErrors()){
            return "register";
        }
        model.addAttribute("user", user);
        return "success";
    }
}