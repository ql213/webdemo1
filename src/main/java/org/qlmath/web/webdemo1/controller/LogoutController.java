package org.qlmath.web.webdemo1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
	
		httpSession.invalidate();
		
		return "redirect:/login.html";
	}
}
