package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 5:43:26 PM
* 类说明
*/
@Controller
public class PageController {
	
	@RequestMapping("login")
	public String toLogin(){
		return "login" ;
	}
	
/*	@RequestMapping("center")
	public String toCenter(){
		return "center" ;
	}*/
	
	@RequestMapping("index")
	public String toIndex(){
		return "index" ;
	}

}
