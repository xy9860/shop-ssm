package com.xy9860.shop.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Product;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductDaoTest {

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testQueryJoinCategory() {
		for (Product temp : productDao.queryJoinCategory("", 1, 3)) {
			System.out.println(temp);
		}
	}

	@Test
	public void testGetCount() {
		System.out.println(productDao.getCount("圣得西服"));
	}

	@Test
	public void testDeleteByIds() {
		productDao.deleteByIds("11,12");
	}

	@Test
	public void testQueryByCid() {
		System.out.println(productDao.queryByCid(4));
	}

	@Test
	public void testGet() {
		System.out.println(productDao.get(3));
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
