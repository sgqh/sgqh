package cn.itcast.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.QueryVo;
import cn.itcast.pojo.User;
import cn.itcast.service.CustService;
import cn.itcast.service.UserService;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 9:45:03 PM
* 更改
* 类说明
*/
@Controller
public class CustController {
	
	@Autowired
	private CustService custService ;
	
	@RequestMapping("/center")
	public String custList(Model model,QueryVo queryVo){
		
		if (StringUtils.isNotBlank(queryVo.getCustName())) {
			model.addAttribute("custName", queryVo.getCustName());
		}
		if (StringUtils.isNotBlank(queryVo.getCustType())) {
			model.addAttribute("custType", queryVo.getCustType());
		}
		
		List<String> types = custService.queryCustType();
		model.addAttribute("types", types);
		
		List<QueryVo> custList = custService.custList(queryVo);
		model.addAttribute("custList", custList);
		
		/*List<String> nicknames = custService.queryCustLinkUser(queryVo);
		model.addAttribute("nicknames", nicknames);*/
		
		return "center";
		
	}
	
	@Autowired
	private UserService userService ;
	@RequestMapping("getUserNickname")
	@ResponseBody
	public List<User> getUserNickname(){
		List<User> nicknames =  userService.getUserNickname();
		System.out.println(nicknames);
		return nicknames ;
	}
	
	@RequestMapping("save")
	public String update(Cust cust){
		custService.save(cust);
		return "redirect:/center";
	}
	
	

	

}
