package com.tmall_ssh.test;
 
import java.util.List;
 
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionContext;
import com.tmall_ssh.dao.CategoryDaoImpl;
import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.pojo.Order;
import com.tmall_ssh.pojo.OrderItem;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.ProductImage;
import com.tmall_ssh.pojo.User;
import com.tmall_ssh.service.ProductImageService;
import com.tmall_ssh.service.ProductService;
 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
    @Autowired
    CategoryDaoImpl dao;
    
 
    @Test
    public void test() {
    	User user = (User) dao.get(User.class, 1);
    	Product pro = (Product) dao.get(Product.class, 91);
    	DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
    	dc.add(Restrictions.eq("user", user));
    	dc.add(Restrictions.eq("product", pro));
    	dc.add(Restrictions.eq("order", null));
    	List<OrderItem> oi = dao.findByCriteria(dc);
    	System.out.println(oi);
    }
}