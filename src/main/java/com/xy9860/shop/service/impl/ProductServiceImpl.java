package com.xy9860.shop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy9860.shop.dao.ProductDao;
import com.xy9860.shop.model.Product;
import com.xy9860.shop.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> queryJoinCategory(String pname, int page, int rows) {
		//两次级联 需要查两次 不然就会报 no session 异常
		//String hql="FROM Product p LEFT JOIN FETCH p.category.account JOIN FETCH p.category WHERE p.pname like ?";//这个多次懒依赖
		return productDao.queryJoinCategory(pname, (page-1)*rows, rows);
	}

	public Long getCount(String pname) {
		return productDao.getCount(pname);
	}
	
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		productDao.deleteByIds(ids);
	}
	
	public List<Product> queryByCid(int cid) {
		return productDao.queryByCid(cid);
	}
/*
	public List<Category> queryJoinAccount(String ctype, int page, int rows) {
		return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type like ?")
				.setParameter(0, "%"+type+"%").list();//没有分页的写法
		String hql="FROM Category c LEFT JOIN FETCH c.account WHERE c.ctype like ?";
		return getSession().createQuery(hql).setParameter(0, "%"+ctype+"%").setFirstResult((page-1)*rows).setMaxResults(rows).list();
		//显示分页
		//加入FETCH 让他抓取后 将结果集 放进 Account
		//return getSession().createQuery("from Category").list();
	}

	public Long getCount(String ctype) {
		String hql="SELECT count(c) FROM Category c WHERE c.ctype like ?";
		return (Long)getSession().createQuery(hql).setParameter(0, "%"+ctype+"%").uniqueResult();
	}

	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String hql="DELETE FROM Category WHERE id IN ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}*/

	public Product get(int pid) {
		// TODO Auto-generated method stub
		return productDao.get(pid);
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}


	
}
