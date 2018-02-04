package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.Cust;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 2, 2017 8:24:34 PM
* 类说明
*/
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper ;

	@Override
	public User checkUser(String username) {
		return userMapper.checkUser(username);
	}

	@Override
	public List<User> getUserNickname() {
		return userMapper.getUserNickname();
	}

	

}
