package com.eksad.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	
	@RequestMapping(value="/mst-item")
	public String index(){
		return "/mst-item/index";
	}
	
	@RequestMapping(value="/mst-item/create")
	public String create(){
		return "/mst-item/create";
	}
	
	@RequestMapping(value="/mst-item/edit")
	public String edit(){
		return "/mst-item/edit";
	}
	
	@RequestMapping(value="/mst-item/delete")
	public String delete(){
		return "/mst-item/delete";
	}
	
	@RequestMapping(value="/mst-item/detail")
	public String detail(){
		return "/mst-item/detail";
	}
}
