package com.tmall_ssh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.service.OrderItemService;
import com.tmall_ssh.service.ProductImageService;
import com.tmall_ssh.service.ProductService;
import com.tmall_ssh.service.ReviewService;
import com.tmall_ssh.util.Page;
@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	
	@Autowired
	private ProductImageService productImageService; 
	@Autowired
	private OrderItemService  orderItemService;
	@Autowired 
	private ReviewService reviewService;
	
	@Override
	public void fill(List<Category> categorys) {
			for(Category category : categorys) {
				List<Product> products = listByParent(category);
				for(Product product:products) {
						productImageService.setFirstProductImage(product);
				}
				category.setProducts(products);
			}
		
	}
	@Override
	public void fillByRow(List<Category> categorys) {
		//定义8个为一个子集合
			int ProductNumberEachRow = 8;
			//遍历查询出所有的category
			for(Category category:categorys) {
				//根据分类查询出单个分类下的所有产品
					List<Product> products = this.listByParent(category);
					//定义一个新集合 
					List<List<Product>> productByRow = new ArrayList<>();
					for(int i = 0;i<products.size();i+=ProductNumberEachRow) {
						//定义size
							int size =i+ ProductNumberEachRow;
							size = size>products.size()?products.size():size;
							//根据i，size切割集合
							List<Product> productOfEachRow = products.subList(i, size);
							productByRow.add(productOfEachRow);
					}
					category.setProductByRow(productByRow);
			}
		
	}

	@Override
	public void setSaleCount(Product product) {
			int salecount = orderItemService.total(product);
			product.setSaleCount(salecount);
		
	}

	@Override
	public void setReviewCount(Product product) {
			int reviewcount = reviewService.total(product);
			product.setReviewCount(reviewcount);
	}
	@Override
	public void setReviewAndCount(List<Product> products) {
			for(Product product : products) {
				this.setSaleCount(product);
				this.setReviewCount(product);
			}
	}
	@Override
	public List<Product> search(String KeyWord,int count,int end) {
		DetachedCriteria dc  = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.like("name","%"+KeyWord+"%" ));
		return this.findByCriteria(dc, count, end);
	}	
	
}
