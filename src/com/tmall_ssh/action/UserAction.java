package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.util.Page;

public class UserAction extends Action4Result{
			@Action("admin_listUser_list")
			public String list() {
				if(page == null) {
					page=new Page();
				}
					int total = userService.total();
					page.setTotal(total);
					users = userService.listByPage(page);
					return "listUser_list";
			}
}
