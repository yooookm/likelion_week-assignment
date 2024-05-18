package study.likelionbeweekly.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.likelionbeweekly.week3.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String loginPage() {
        return "signIn";
    }


    @GetMapping("/joinPage")
    public String joinPage() {
        return "signUp";
    }


    @PostMapping("/join")
    public String join(@RequestParam("id") String id,
                       @RequestParam("password") String password) {

        // 이곳에 userService.saveUser 에 id와 password 를 전달해서 User 를 저장해보세요.
        return "signIn";
    }


    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password, Model model) {

        // 이곳에 userService.login 에 id, password 그리고 model 을 전달해서 로그인해보세요.
        return "info";
    }
}
