package com.eksad.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {
	
	@RequestMapping(value="/mst-role")
	public String index(){
		return "/mst-role/index";
	}
	
	@RequestMapping(value="/mst-role/create")
	public String create(){
		return "/mst-role/create";
	}
	
	@RequestMapping(value="/mst-role/edit")
	public String edit(){
		return "/mst-role/edit";
	}
	
	@RequestMapping(value="/mst-role/delete")
	public String delete(){
		return "/mst-role/delete";
	}
	
	@RequestMapping(value="/mst-role/detail")
	public String detail(){
		return "/mst-role/detail";
	}
}
