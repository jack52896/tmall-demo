package com.tmall_ssh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall_ssh.dao.CategoryDaoImpl;
import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.service.BaseService;
import com.tmall_ssh.service.impl.delegate.ServiceDelegateDao;
import com.tmall_ssh.util.Page;

@Service
public class BaseServiceImpl extends ServiceDelegateDao implements BaseService {

	protected Class clazz;
	public BaseServiceImpl() {
		try {
			throw new Exception();
		}catch(Exception e) 
		{
			StackTraceElement stes[] = e.getStackTrace();
			String serviceImplClassName = stes[1].getClassName();
			try {
				Class serviceImplClazz = Class.forName(serviceImplClassName);
				String serviceImplClazzName = serviceImplClazz.getSimpleName().replaceAll("ServiceImpl", "");
				String servicePackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
				String FullClassName = servicePackageName+"."+serviceImplClazzName;
				clazz = Class.forName(FullClassName);
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	@Override
	public List list() {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
	public List listByPage(Page page){
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc,page.getStart(),page.getCount());
	}
	@Override
	public int total() {
		String hql = "select count(*) from "+clazz.getName();
		List<Long> ls = find(hql);
		if(ls.isEmpty()) {
			return 0;
		}
		Long result = ls.get(0);
		return result.intValue();
	}
	@Override
	public Integer save(Object object) {
		return (Integer)super.save(object);
	}
	@Override
	public void delete(Object object) {
		super.delete(object);
	}
	@Override
	public Object get(int cid) {
		
		return get(clazz,cid);
	}
	@Override
	public void update(Object object) {
		
		super.update(object);
	}
	@Override
	public List listByParent(Object parent) {
		String parentName = parent.getClass().getSimpleName();
		String parentNameLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);//Category.class
		dc.add(Restrictions.eq(parentNameLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
	@Override
	public List list(Page page, Object parent) {
		String parentName = parent.getClass().getSimpleName();
		String parentNameLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc  = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc,page.getStart(),page.getCount());
	}
	@Override
	public int total(Object parentObject) {
		String parentName= parentObject.getClass().getSimpleName();
		String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
		
		String sqlFormat = "select count(*) from %s bean where bean.%s = ?";
		String hql = String.format(sqlFormat, clazz.getName(), parentNameWithFirstLetterLower);
		
		List<Long> l= this.find(hql,parentObject);
		if(l.isEmpty())
			return 0;
		Long result= l.get(0);
		return result.intValue();

	}
	@Override
	public List list(String name) {
		DetachedCriteria dc  = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq("name", name));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
	@Override
	public List list(String name, String password) {
		DetachedCriteria dc= DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq("name",name));
		dc.add(Restrictions.eq("password", password));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
	@Override
	public List list(Object... pairParms) {
		HashMap<String,Object> m = new HashMap<>();
		for (int i = 0; i < pairParms.length; i=i+2) 
			m.put(pairParms[i].toString(), pairParms[i+1]);

		DetachedCriteria dc = DetachedCriteria.forClass(clazz);

		Set<String> ks = m.keySet();
		for (String key : ks) {
			if(null==m.get(key))
				dc.add(Restrictions.isNull(key));
			else
				dc.add(Restrictions.eq(key, m.get(key)));
		}
		dc.addOrder(Order.desc("id"));
		return this.findByCriteria(dc);
	}
	
	
}
