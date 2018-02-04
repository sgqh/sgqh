package cn.itcast.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 7:59:24 PM
* 类说明
*/
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService ;

	@RequestMapping("/checkLogin")
	public String checkLogin(User user){
		user = userService.checkUser(user.getUsername());
		if (user != null) {
			return "index";
		}else{
			return "login";
		}
		
	}
	
	
}
