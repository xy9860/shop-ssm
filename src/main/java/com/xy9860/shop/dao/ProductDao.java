package com.xy9860.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xy9860.shop.model.Product;

public interface ProductDao {
	//分页查询
	public List<Product> queryJoinCategory(@Param("pname")String pname,@Param("offset") int offset,@Param("limit") int limit);
	//获得所有商品的数量
	public Long getCount(String pname);
	//前端的多行删除
	public void deleteByIds (String ids);
	//根据热点类别查询4的商品
	public List<Product> queryByCid(int cid);
	public Product get(int pid);
	public void save(@Param("product")Product product);
	public void update(@Param("product")Product product);
}
