package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    // ��¼
    @RequestMapping(value = "/login")
    public String login(HttpSession session, String username, String password,
            Model model) {
        // �ж��û����������Ƿ���ȷ
        if (username.equals("shiyanlou") && password.equals("123456")) {
            session.setAttribute("username", username);
            // �ض��� test ����
            return "redirect:test";
        } else {
            model.addAttribute("message", "wrong user name or password!");
            return "loginform";
        }
    }

    // �ǳ�
    @RequestMapping(value = "/loginout")
    public String loginout(HttpSession session) throws Exception {
        session.invalidate();
        return "loginform";
    }
}