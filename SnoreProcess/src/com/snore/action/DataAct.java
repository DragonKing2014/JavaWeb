package com.snore.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataAct {

	@RequestMapping(value="/data",method=RequestMethod.POST)
	public String data(HttpServletRequest request, ModelMap model){
		System.out.println("”√ªßµ«»Î£°");
		return "/data/data";
	}
	
}
