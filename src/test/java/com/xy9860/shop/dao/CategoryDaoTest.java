package com.xy9860.shop.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xy9860.shop.model.Account;
import com.xy9860.shop.model.Category;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void testQueryJoinAccount() {
		for (Category category : categoryDao.queryJoinAccount("", 0, 2)) {
			System.out.println(category.getAccount());
		}
	}

	@Test
	public void testGetCount() {
		System.out.println(categoryDao.getCount("老人休闲"));
	}

	@Test
	public void testDeleteByIds() {
		categoryDao.deleteByIds("1,2");
	}

	@Test
	public void testQueryByChot() {
		System.out.println(categoryDao.queryByChot(true));
	}

	@Test
	public void testQuery() {
		for (Category category : categoryDao.query()) {
			System.out.println(category);
		}
	}

	@Test
	public void testSave() {
		Category category=new Category();
		Account account=new Account();
		//account.setAid(321);
		category.setAccount(account);
		category.setChot(true);
		category.setCtype("美术");
		categoryDao.save(category);
	}

	@Test
	public void testUpdate() {
		Category category=new Category();
		Account account=new Account();
		account.setAid(321);
		category.setAccount(account);
		category.setChot(true);
		category.setCtype("美术11111111111111111");
		category.setCid(5);
		categoryDao.update(category);
	}

}
