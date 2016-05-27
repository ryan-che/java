package com.github.hualuomoli.demo.base.service.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hualuomoli.base.entity.Pagination;
import com.github.hualuomoli.demo.base.entity.Demo;
import com.github.hualuomoli.demo.base.mapper.DemoMapper;
import com.github.hualuomoli.demo.base.service.DemoService;

@Service(value = "com.github.hualuomoli.demo.base.service.orm.OrmDemoService")
public class OrmDemoService implements DemoService {

	@Autowired
	private DemoMapper demoMapper;

	@Override
	public Demo get(String id) {
		Demo demo = demoMapper.get(id);
		if (demo == null) {
			throw new RuntimeException("there is no data which id is " + id);
		}
		return demo;
	}

	@Override
	public void insert(Demo demo) {
		demo.preInsert();
		int result = demoMapper.insert(demo);
		if (result != 1) {
			throw new RuntimeException("there may return one.but find " + result);
		}
	}

	@Override
	public void update(Demo demo) {
		demo.preUpdate();
		int result = demoMapper.update(demo);
		if (result != 1) {
			throw new RuntimeException("there may return one.but find " + result);
		}
	}

	@Override
	public void delete(String id) {
		int result = demoMapper.delete(id);
		if (result != 1) {
			throw new RuntimeException("there may return one.but find " + result);
		}
	}

	@Override
	public List<Demo> findList(Demo demo) {
		return demoMapper.findList(demo);
	}

	@Override
	public Pagination findPage(Demo demo, Pagination pagination) {
		demo.setPagination(pagination);
		pagination.setDataList(demoMapper.findList(demo));
		return pagination;
	}

}
