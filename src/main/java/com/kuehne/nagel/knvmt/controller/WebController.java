package com.kuehne.nagel.knvmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping(value={"/","home"})
	public ModelAndView home(){
		//return "home";
		return new ModelAndView("view/home.jsf");
	}
	
	@RequestMapping(value={"/login"})
	public ModelAndView login(){
		//return "login";
		return new ModelAndView("view/login.jsf");
	}
		
	/*@RequestMapping(value="/403")
	public String Error403(){
		System.out.println("--------------> 403");
		return "403";
	}*/
}
