package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

/**
 * UserController ��һ������ע��Ŀ�����
 * ����ͬʱ������������
 */
@Controller
public class UserController {
    /**
     * RequestMapping ����ӳ��һ�����������ķ���
     * value="/register" ��ʾ������ register �������д���
     */
    @RequestMapping(value="/register")
    public String Register(User user, Model model) {  // user:��ͼ�㴫�����Ʋ�ı�����model�����Ʋ㷵�ظ���ͼ��Ķ���
        // �� model �����һ����Ϊ "user" �� user ����
        model.addAttribute("user", user);
        // ����һ���ַ��� " success" ��Ϊ��ͼ����
        return "success";
    }
}