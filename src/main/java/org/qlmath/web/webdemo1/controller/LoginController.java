package org.qlmath.web.webdemo1.controller;

import javax.servlet.http.HttpSession;

import org.qlmath.web.webdemo1.cache.CacheUtils;
import org.qlmath.web.webdemo1.model.UserDTO;
import org.qlmath.web.webdemo1.tools.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private CacheUtils cacheUtils;

	
	/** 
     * jump to login
     * @return
     */
	@RequestMapping(value = {"/login.html", "login"})
	public String toLogin(ModelMap model) {
		return "login";
	}
	
	 /**
     * login submit
     * @param username
     * @param password
     * @param model
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDTO user, ModelMap model, HttpSession httpSession) {	

		 UserDTO userFromCache = cacheUtils.getUsersData().get(user.getUserId());
        
         if (userFromCache == null || !userFromCache.getPassword().equals(
        		 MD5Utils.encode(user.getPassword(), "utf-8").toUpperCase())) {
        	model.put("message", "User id or password error.");
            return "login";
        }
         
        httpSession.setAttribute("user", userFromCache);

        return "redirect:/main.html";
	}
}
