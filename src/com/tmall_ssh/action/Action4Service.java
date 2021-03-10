package com.tmall_ssh.action;

import java.lang.reflect.Method;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmall_ssh.service.*;
public class Action4Service extends Action4Pojo {
			@Autowired
			protected CategoryService categoryService;
			@Autowired
			protected PropertyService propertyService;
			@Autowired
			protected ProductService productService;
			@Autowired
			protected ProductImageService productImageService;
			@Autowired
			protected PropertyValueService propertyValueService;
			@Autowired
			protected UserService userService;
			@Autowired
			protected OrderItemService orderItemService;
			@Autowired
			protected OrderService orderService;
			@Autowired
			protected ReviewService reviewService;
			
			//使得瞬时对象转换为持久状态
			public void t2p(Object o){
	            try {
	                Class clazz = o.getClass();
	                int id = (Integer) clazz.getMethod("getId").invoke(o);
	                Object persistentBean = categoryService.get(id);
	 
	                String beanName = clazz.getSimpleName();
	                Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
	                setMethod.invoke(this, persistentBean);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	    }
}
