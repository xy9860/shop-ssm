package com.xy9860.shop.dao;

import java.util.List;

public interface SorderDao  {
	//查询热点商品的销售量
	public List<Object> querySale(int pid);
}
