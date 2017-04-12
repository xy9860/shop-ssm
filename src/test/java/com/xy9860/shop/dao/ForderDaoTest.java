package com.xy9860.shop.dao;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Forder;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ForderDaoTest {

	@Autowired
	private ForderDao forderDao;
	
	@Test
	public void testUpdateStatusByFid() {
		forderDao.updateStatusByFid(324375735, 11);
	}

	@Test
	public void testSave() {
		Forder forder=new Forder("fname", "电话", "frese", null, new BigDecimal("123"), "75892", "321");
		forderDao.save(forder);
	}

}
