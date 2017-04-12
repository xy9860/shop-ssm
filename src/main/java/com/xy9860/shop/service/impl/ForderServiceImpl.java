package com.xy9860.shop.service.impl;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy9860.shop.dao.ForderDao;
import com.xy9860.shop.model.Forder;
import com.xy9860.shop.model.Sorder;
import com.xy9860.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl implements ForderService {

	@Autowired
	private ForderDao forderDao;
	
	public Forder addSorder(Forder forder, Sorder sorder) {
		Iterator<Sorder> it=forder.getSorders().iterator();
		while (it.hasNext()) {
			Sorder temp=it.next();
			if (temp.hashCode()==sorder.hashCode()) {// 如果购物车中存在同样的商品
				sorder.setSnumber(temp.getSnumber()+1);
				forder.getSorders().remove(temp);
				break;
			}
		}
		sorder.setForder(forder);//建立购物项和购物车的关联,此时forder为空,入库时先入forder再入购物车  就会有fid
		forder.getSorders().add(sorder);
		/*Iterator<Sorder> it2=forder.getSorders().iterator();
		while (it2.hasNext()) {
			Sorder temp=it2.next();
			if (forder.getFtotal()==null) {
				forder.setFtotal(new Double(0));
			}
			System.out.println(forder.getFtotal());
			System.out.println(temp.getSprice());
			System.out.println(temp.getSprice()*temp.getSnumber());
			forder.setFtotal(forder.getFtotal()+temp.getSprice());
		}*/
		return forder;
	}
	
	public BigDecimal cluTotal(Forder forder){
		BigDecimal total=new BigDecimal(0.00);
		for (Sorder sorder : forder.getSorders()) {
			total=total.add(sorder.getSprice().multiply(new BigDecimal(sorder.getSnumber())));
			
		}
		return total;
	}

	public void updateStatusByFid(int fid, int tid) {
		forderDao.updateStatusByFid(fid, tid);
	}

	public void save(Forder forder) {
		// TODO Auto-generated method stub
		forderDao.save(forder);
	}
}
