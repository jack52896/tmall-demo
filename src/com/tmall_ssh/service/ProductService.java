package com.tmall_ssh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.util.Page;

@Service
public interface ProductService extends BaseService {
	
			//为分类填充产品集合
			public void fill(List<Category> categorys);
			
			
			public void fillByRow(List<Category> categorys);
			
			public void setSaleCount(Product product);
			
			public void setReviewCount(Product product) ;
			public void setReviewAndCount(List<Product> products);
			public List<Product> search(String KeyWord , int count,int end);
}
