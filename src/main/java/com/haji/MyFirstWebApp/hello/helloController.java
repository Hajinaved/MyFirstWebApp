package com.haji.MyFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
	@RequestMapping("h1")
	@ResponseBody
	public String ss() {
		return " hello";
	}
	@RequestMapping("h2")
	public String sss() {
		return"First";
	}
}
