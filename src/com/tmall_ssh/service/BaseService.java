package com.tmall_ssh.service;

import java.util.List;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.util.Page;

public interface BaseService {
	public List list();
	public List listByPage(Page page );
	public int total();
	public Integer save(Object object);
	public void delete(Object object);
	public Object get(int cid);
	public void update(Object object);
	
	public List listByParent(Object parent);
	public List list(Page page , Object parent);
	public int total(Object parentObject);
	public List list(String name);
	public List list(String name,String password);
	
	 public List list(Object ...pairParms);
}
