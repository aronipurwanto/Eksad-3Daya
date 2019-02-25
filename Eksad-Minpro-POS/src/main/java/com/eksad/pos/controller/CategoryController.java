package com.eksad.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@RequestMapping(value="/mst-category")
	public String index(){
		return "/mst-category/index";
	}
	
	@RequestMapping(value="/mst-category/create")
	public String create(){
		return "/mst-category/create";
	}
	
	@RequestMapping(value="/mst-category/edit")
	public String edit(){
		return "/mst-category/edit";
	}
	
	@RequestMapping(value="/mst-category/delete")
	public String delete(){
		return "/mst-category/delete";
	}
	
	@RequestMapping(value="/mst-category/detail")
	public String detail(){
		return "/mst-category/detail";
	}
}
