package com.tmall_ssh.service;

import java.util.List;

import com.tmall_ssh.pojo.User;

public interface UserService extends BaseService {
		public boolean isEmpty(String name);
		public User isEmpty(String name,String password);
}
