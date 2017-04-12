package com.xy9860.shop.dao;

import org.apache.ibatis.annotations.Param;

import com.xy9860.shop.model.User;


public interface UserDao   {
	public User login(@Param("user")User user);
}
