package study.likelionbeweekly.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.likelionbeweekly.week3.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/" 입니다.
	 */
	@GetMapping("/")
	public String loginPage() {
		return "signIn";
	}

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/joinPage" 입니다.
	 */
	@GetMapping("/joinPage")
	public String joinPage() {
		return "signUp";
	}

	/**
	 * 이곳에 POST 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/join" 입니다.
	 */
	@GetMapping("/join")
	public String join(@RequestParam("id") String id,
					   @RequestParam("password") String password) {

		// 이곳에 userService.saveUser 에 id와 password 를 전달해서 User 를 저장해보세요.
		return "signIn";
	}

	/**
	 * 이곳에 POST 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/login" 입니다.
	 */
	@GetMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("password") String password, Model model) {

		// 이곳에 userService.login 에 id, password 그리고 model 을 전달해서 로그인해보세요.
		return "info";
	}
}
