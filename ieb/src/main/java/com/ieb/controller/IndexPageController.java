package com.ieb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页相关
 * @author zhengjie
 */
@Controller
public class IndexPageController {
	
	//登录页
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

}
