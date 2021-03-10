package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.util.Page;

public class OrderAction extends Action4Result{
			@Action("admin_listOrder_list")
			public String list() {
				if(page == null) {
					page = new Page();
				}
				int total = orderService.total();
				page.setTotal(total);
				orders = orderService.listByPage(page);
				orderItemService.fill(orders);
				return "listOrder_list";
			}
}
