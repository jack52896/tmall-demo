package com.tmall_ssh.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.tmall_ssh.pojo.User;
import com.tmall_ssh.service.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public boolean isEmpty(String name) {
			List l = this.list(name);
			if(l.isEmpty()) {
				return false;
			}
			return true;
	}

	@Override
	public User isEmpty(String name, String password) {
			List<User> l = this.list(name, password);
			if(l.isEmpty()) {
				System.out.println(l.get(0).getName());
				return  null;
			}else {
				ActionContext.getContext().getSession().put("user",l.get(0));
				return l.get(0);
			}
	}
}
