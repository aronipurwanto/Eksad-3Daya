package com.eksad.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.eksad.pos.service.MstUserService;

@Controller
public class BaseController {
	@Autowired
	MstUserService userService;
	
	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			return userDetail.getUsername();
		}
		return null;
	}
	
	public Integer getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			User user = (User) auth.getPrincipal();
			return userService.getByUsername(user.getUsername()).getId();
		}
		return null;
	}
}
