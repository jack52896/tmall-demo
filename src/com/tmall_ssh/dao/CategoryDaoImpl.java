package com.tmall_ssh.dao;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class CategoryDaoImpl extends HibernateTemplate {
		@Resource(name = "sf")
		public void setSessionFactory(SessionFactory sessionFactory) {
				super.setSessionFactory(sessionFactory);
		};
}
