package com.cts.eb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EBController {

	@RequestMapping(value="/home.htm")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/add.htm")
	public ModelAndView add(@RequestParam int a, @RequestParam int b) {
		int c = a + b;
		return new ModelAndView("result", "key", c);
	}

}
