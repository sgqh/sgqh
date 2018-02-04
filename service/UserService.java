package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.User;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 8:17:39 PM
* 类说明
*/
public interface UserService {

	User checkUser(String username);

	List<User> getUserNickname();

	
	
	

}
