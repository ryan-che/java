package com.github.hualuomoli.demo.base.service;

import java.util.Collection;
import java.util.List;

import com.github.hualuomoli.base.entity.Page;
import com.github.hualuomoli.base.plugin.mybatis.entity.Order;
import com.github.hualuomoli.base.plugin.mybatis.entity.Pagination;
import com.github.hualuomoli.demo.base.entity.BaseUser;

// #BaseUser
public interface BaseUserService {

	BaseUser get(BaseUser baseUser);
	
	BaseUser get(String id);

	int insert(BaseUser baseUser);
	
	int batchInsert(List<BaseUser> list);

	int update(BaseUser baseUser);
	
	int logicalDelete(BaseUser baseUser);

	int logicalDelete(String id);

	int delete(BaseUser baseUser);
	
	int delete(String id);
	
	int deleteByIds(String[] ids);
	
	int deleteByIds(Collection<String> ids);

	List<BaseUser> findList(BaseUser baseUser);
	
	Page findPage(BaseUser baseUser, Integer pageNo, Integer pageSize);

	Page findPage(BaseUser baseUser, Integer pageNo, Integer pageSize, String... orderByStrArray);

	Page findPage(BaseUser baseUser, Integer pageNo, Integer pageSize, Order... orders);

	Page findPage(BaseUser baseUser, Integer pageNo, Integer pageSize, List<Order> orders);

	Page findPage(BaseUser baseUser, Pagination pagination);
	
}
