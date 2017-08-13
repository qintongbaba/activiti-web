package org.wuqinghua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wuqinghua.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(String name) {
		boolean login = loginService.login(name);
		if (login) {
			return "main";
		}
		return "login";
	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		loginService.logout();
		return "login";
	}

	@RequestMapping("/top")
	public String top() {
		return "top";
	}

	@RequestMapping("/left")
	public String left() {
		return "left";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
