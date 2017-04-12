package com.xy9860.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xy9860.shop.model.Category;

public interface CategoryDao{
	public List<Category> queryJoinAccount(@Param("ctype")String ctype,@Param("offset") int offset,@Param("limit") int limit);
	public Long getCount(String ctype);
	//根据ID删除多条记录
	public void deleteByIds (String ids);
	//查询热点类别
	public List<Category> queryByChot(boolean chot);
	public List<Category> query();
	public void save(@Param("category")Category category);
	public void update(@Param("category")Category category);
}
