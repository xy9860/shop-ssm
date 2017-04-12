package com.xy9860.shop.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xy9860.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		pageMap =new HashMap<String, Object>();//用来存储分页的数据
		List<Product> Products= productService.queryJoinCategory(model.getPname(), page, rows);//根据关键字和分页参数查询相应的数据
		Long total=productService.getCount(model.getPname());//根据关键字和分页参数查询相应的数据的条数
		pageMap.put("total", total);
		pageMap.put("rows", Products);
		return "jsonMap";
	}
	
public String deleteByIds(){
		
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());//返回为 true 
		
		return "stream";
	}
	
	public void save(){
		//实现文件上传的功能,并把生成的UUID文件名交给 pic
		//System.out.println(fileImage);
		//抽取成为一个工具类
		//String ext=FilenameUtils.getExtension(fileImage.getFilename());
		//FileUtil.copyFile(fileImage.getFile(),new File("c:/"+UUID.randomUUID()+"."+ext) );
		String pic=fileUpload.uploadFile(fileImage);//执行上传工具类 返回真实文件名
		model.setPic(pic);
		//商品入库
		productService.save(model);
	}
	
	public void update(){
		productService.update(model);
	}
	
	public String get(){
		request.put("product", productService.get(model.getPid()));
		return "detail";
	}
}
