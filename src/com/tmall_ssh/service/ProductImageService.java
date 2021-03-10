package com.tmall_ssh.service;

import java.util.List;

import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.ProductImage;

public interface ProductImageService extends BaseService {
	public static final String type_single = "type_single";
	public static final String type_detail = "type_detail";
	public List<ProductImage> list(String key_product,Product product,String key_type,String type);
	public void setFirstProductImage(Product product);
	public void setFirstProductImages(List<Product> products);
}
