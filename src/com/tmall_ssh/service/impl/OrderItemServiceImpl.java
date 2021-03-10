  package com.tmall_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall_ssh.pojo.Order;
import com.tmall_ssh.pojo.OrderItem;
import com.tmall_ssh.service.OrderItemService;
import com.tmall_ssh.service.ProductImageService;
@Service
public class OrderItemServiceImpl extends BaseServiceImpl implements OrderItemService{
	@Autowired
	private ProductImageService productImageService;
	@Override
	public void fill(Order order) {
		List<OrderItem> orderItems = this.listByParent(order);
		order.setOrderItems(orderItems);
		float total =0 ;
		int totalNumber = 0;
		for(OrderItem oi : orderItems) {
			total+=oi.getNumber()*oi.getProduct().getPromotePrice();
			totalNumber+=oi.getNumber();
			productImageService.setFirstProductImage(oi.getProduct());
		}
		order.setTotal(total);
		order.setTotalNumber(totalNumber);
		order.setOrderItems(orderItems);
	}

	@Override
	public void fill(List<Order> orders) {
		for(Order od:orders){
			this.fill(od);
		}
		
	}
		
}
