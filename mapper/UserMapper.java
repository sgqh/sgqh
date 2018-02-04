package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.User;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 8:26:05 PM
* 类说明
*/
public interface UserMapper {

	User checkUser(String username);

	List<User> getUserNickname();
	
	

}
