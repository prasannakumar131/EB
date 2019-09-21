package com.cts.eb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.eb.dto.EBDTO;
import com.cts.eb.service.EBService;
import com.cts.eb.vo.EBVO;

@Controller
public class EBController {
	@Autowired
	private EBService service;

	@RequestMapping(value="/home.htm")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/add.htm")
	public ModelAndView add(@ModelAttribute EBVO ebvo) {
		EBDTO ebdto=null;
		ebdto=new EBDTO();
		ebdto.setServiceNo(Long.parseLong(ebvo.getServiceNo()));
		ebdto.setCustomerName(ebvo.getCustomerName());
		ebdto.setAddress(ebvo.getAddress());
		ebdto.setMobile(Long.parseLong(ebvo.getMobile()));
		ebdto.setEmail(ebvo.getEmail());
		ebdto.setUnits(Integer.parseInt(ebvo.getUnits()));
		
		ebdto=service.registerCustormer(ebdto);		
		return new ModelAndView("result", "dtokey", ebdto);
	}

}
