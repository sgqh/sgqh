package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.mapper.CustMapper;
import cn.itcast.pojo.Cust;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.CustService;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 3, 2017 2:41:44 PM
* 类说明
*/
@Service
public class CustServiceImpl implements CustService {
	
	@Autowired
	private CustMapper custMapper ;

	

	@Override
	public List<QueryVo> custList(QueryVo queryVo) {
		return custMapper.custList(queryVo);
	}



	@Override
	public List<String> queryCustType() {
		return custMapper.queryCustType();
	}



	@Override
	public List<String> queryCustLinkUser(QueryVo queryVo) {
		return custMapper.queryCustLinkUser(queryVo);
	}



	@Override
	public void save(Cust cust) {
		custMapper.save(cust);
	}

	

}
