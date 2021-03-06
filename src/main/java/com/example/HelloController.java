package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello0", method=RequestMethod.GET)
	@ResponseBody
	public String hello(){
		return "Message";
	}
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam String message){
		return "Message GET : " + message;
	}
	
	@RequestMapping(value = "/hello", method=RequestMethod.POST)
	public String hello2(@RequestBody String message){
		return "Hello POST : " + message;
	}

	@RequestMapping(value = "/hello/{message}", method=RequestMethod.PUT)
	@ResponseBody
	public String hello3(@PathVariable String message){
		return "Hello PUT :" + message;
	}
	
	@RequestMapping(value = "/hellojsp", method = RequestMethod.GET)
	public String hello(ModelMap modelMap){
		modelMap.addAttribute("message", "Hello Spring from JSP");
		return "hello";
	}
	
}
