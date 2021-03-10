package com.tmall_ssh.service;

import java.util.List;

import com.tmall_ssh.pojo.Order;

public interface OrderItemService extends BaseService{
		public void fill(Order order);
		public void fill(List<Order> orders);
}
