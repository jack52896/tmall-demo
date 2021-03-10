package com.tmall_ssh.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.ProductImage;
import com.tmall_ssh.service.ProductImageService;
@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService {

	@Override
	 public List<ProductImage> list(String key_product, Product product, String key_type, String type) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.eq(key_product, product));
        dc.add(Restrictions.eq(key_type, type));
        dc.addOrder(Order.desc("id"));
        return this.findByCriteria(dc);
    }

	@Override
	public void setFirstProductImage(Product product) {
		if(product.getFirstProductImage() != null) {
				return;
		}
		List<ProductImage> pis = this.list("product", product, "type", ProductImageService.type_single);
		if(!pis.isEmpty()) {
				product.setFirstProductImage(pis.get(0));
		}
	}

	@Override
	public void setFirstProductImages(List<Product> products) {
		for(Product product : products) {
			setFirstProductImage(product);
		}
		
	}
	
}
