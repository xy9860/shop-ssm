package com.xy9860.shop.dao;

import org.apache.ibatis.annotations.Param;

import com.xy9860.shop.model.Forder;


public interface ForderDao {
	//根据订单编号,更新订单状态
	public void updateStatusByFid(@Param("fid")int fid,@Param("tid")int tid);

	public void save(Forder forder);
}
