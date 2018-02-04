package cn.itcast.mapper;

import java.util.List;

import cn.itcast.pojo.Cust;
import cn.itcast.pojo.QueryVo;

/**
* @author 作者 E-mail:
* @version 创建时间：Dec 3, 2017 2:42:49 PM
* 类说明
*/
public interface CustMapper {


	List<QueryVo> custList(QueryVo queryVo);

	List<String> queryCustType();

	List<String> queryCustLinkUser(QueryVo queryVo);

	void save(Cust cust);

	
	
	

}
