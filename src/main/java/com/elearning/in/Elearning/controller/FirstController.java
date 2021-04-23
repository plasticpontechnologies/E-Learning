package com.elearning.in.Elearning.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.elaerning.in.Elearning.model.User;
import com.elearning.in.Elearning.service.UserService;


@RestController
public class FirstController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView firstUrl() {
		ModelAndView first = new ModelAndView("");// first.addObject("loginUser", new LoginUser());
		return first;
	}

	
	/*
	 * @RequestMapping("/signup") public ModelAndView viewRegisterPage() {
	 * ModelAndView signUp = new ModelAndView(""); signUp.addObject("user", new
	 * User()); return signUp; }
	 */

	@RequestMapping("/login")
	public ModelAndView viewLoginPage() {
		ModelAndView signUp = new ModelAndView("sign_in ");
		// signUp.addObject("user", new User());
		return signUp;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void  registerUser(@RequestBody User user) {
		System.out.println(user.getFirstname());
		userService.saveUser(user);
		
	}

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody public String visitHome() {
	 * 
	 * 
	 * 
	 * return "KRISHNA"; }
	 */
	@RequestMapping(value = "/loginSuccess")
	public ModelAndView loginSuccess(Principal principal) {
		ModelAndView loginSuccess = new ModelAndView();
		loginSuccess.setViewName("");//client_dashboard
		
		/*System.out.println(principal.getName());
		String roleName = userService.getRoleByName(principal.getName());
		if (roleName.equalsIgnoreCase(Constants.role_user)) {
			loginSuccess.setViewName("dashboard_main");
		} else if (roleName.equalsIgnoreCase(Constants.role_admin)) {
			loginSuccess.setViewName("AgentDashBoard");
		}*/

		return loginSuccess;
	}
}
