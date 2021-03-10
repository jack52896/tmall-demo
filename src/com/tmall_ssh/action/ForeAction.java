package com.tmall_ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionContext;
import com.tmall_ssh.pojo.Order;
import com.tmall_ssh.pojo.OrderItem;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.PropertyValue;
import com.tmall_ssh.pojo.User;

public class ForeAction extends Action4Result{
			@Action("forehome")
			public String home() {
					categorys = categoryService.list();
					productService.fill(categorys);
					productService.fillByRow(categorys);
					return "home.jsp";
			}
			@Action("foreRegister")
			public String register() {
					user.setName(HtmlUtils.htmlEscape(user.getName()));
					boolean  exist = userService.isEmpty(user.getName());
					if(exist) {
							msg = "用户名已经存在,不能使用";
							return "register.jsp";
					}else {
							userService.save(user);
							return "registerSuccessPage.jsp";
					}
					
			} 
			@Action("forelogin")
			public String login() {
					user.setName(HtmlUtils.htmlEscape(user.getName()));
					user.setPassword(HtmlUtils.htmlEscape(user.getPassword()));
					User user_session = userService.isEmpty(user.getName(),user.getPassword());
					if(user_session == null) {
							msg="账号密码错误";
							return "login.jsp";
					}else {
							ActionContext.getContext().getSession().put("user", user_session);
							return "homepage";
					}
			}
			@Action("forelogout")
			public String loginout() {
					ActionContext.getContext().getSession().remove("user");
					return "homepage";
			}
			@Action("foreproduct")
			public String foreduct() {
					product = (Product) productService.get(product.getId());
					productSingleImages= productImageService.list("product", product, "type", productImageService.type_single);
					productDetailImages= productImageService.list("product", product, "type", productImageService.type_detail);
					product.setProductSingleImages(productSingleImages);
					product.setProductDetailImages(productDetailImages);
					productImageService.setFirstProductImage(product);
					propertyValues = propertyValueService.listByParent(product);
					productService.setReviewCount(product);
					productService.setSaleCount(product);
					user = (User) ActionContext.getContext().getSession().get("user");
					reviews =  reviewService.listByParent(product);
					return "product.jsp";
			}
			@Action("forecheckLogin")
			public String checkLogin() {
				User u =(User) ActionContext.getContext().getSession().get("user");
			    if(null==u)
			        return "fail.jsp";
			    else
			        return "success.jsp";
			}
			@Action("foreloginAjax")
			public String AjaxLogin() {
					user.setName(HtmlUtils.htmlEscape(user.getName()));
					User user_session = userService.isEmpty(user.getName(), user.getPassword());
					if(user_session==null) {
						return "fail.jsp";
					}else {
						ActionContext.getContext().getSession().put("user", user_session);
						return  "success.jsp";
					}
			}
			@Action("foresearch")
			public String search() {
					System.out.println(param.getKeyword());
					products = productService.search(param.getKeyword(), 0, 20);
					for(Product product : products) {
						productImageService.setFirstProductImage(product);
					}
					productService.setReviewAndCount(products);
					return "searchResults.jsp";
			}
			@Action("forebuyone")
			public String buy() {
					User user = (User) ActionContext.getContext().getSession().get("user");
					product = (Product) productService.get(product.getId());
					List<OrderItem> orderItems = orderItemService.list("user",user,"product",product,"order",null);
					System.out.println(orderItems);
					if(orderItems.isEmpty()) {
						OrderItem orderItem = new OrderItem();
						orderItem.setNumber(num);
						orderItem.setProduct(product);
						orderItem.setUser(user);
						orderItemService.save(orderItem);
						oiid = orderItem.getId();
					}else {
						for(OrderItem orderItem : orderItems) {
							orderItem.setNumber(orderItem.getNumber()+num);	
							orderItemService.update(orderItem);
							oiid =  orderItem.getId();
							break;
						}
						
					}
					return "buyPage.jsp";
			}	
			@Action("foreBuy")
			public String buyAll() {
					orderItems = new ArrayList<>();
					for(int oiid : oiids) {
						OrderItem oi = (OrderItem) orderItemService.get(oiid);
						System.out.println(oi.getNumber());
						total += (oi.getProduct().getPromotePrice()) * (oi.getNumber());
						orderItems.add(oi);
						productImageService.setFirstProductImage(oi.getProduct());
					}
					ActionContext.getContext().getSession().put("orderItems", orderItems);
					return "buy.jsp";
			}
			@Action("foreaddCart")
			public String addCart() {
					User user = (User) ActionContext.getContext().getSession().get("user");
					product = (Product) productService.get(product.getId());
					List<OrderItem> orderItems = orderItemService.list("user",user,"product",product,"order",null);
					if(orderItems.isEmpty()) {
						OrderItem orderItem = new OrderItem();
						orderItem.setNumber(num);
						orderItem.setProduct(product);
						orderItem.setUser(user);
						orderItemService.save(orderItem);
					}else {
						for(OrderItem orderItem : orderItems) {
							orderItem.setNumber(orderItem.getNumber()+num);
							orderItemService.update(orderItem);
							break;
						}
					}
					return "success.jsp";
			}
			@Action("forecart")
			public String Cart() {
					User user = (User) ActionContext.getContext().getSession().get("user");
					orderItems = orderItemService.list("user",user,"order",null);
					System.out.println(orderItems);
					for(OrderItem orderItem : orderItems) {
						productImageService.setFirstProductImage(orderItem.getProduct());
					}
					return "cart.jsp";
			}
			@Action("forechangeOrderItem")
			public String change() {
					User user = (User) ActionContext.getContext().getSession().get("user");
					List<OrderItem> orderItems = orderItemService.list("user",user,"product",product,"order",null);
					for(OrderItem orderItem : orderItems) {
						orderItem.setNumber(num);
						orderItemService.update(orderItem);
						break;
					}
					return "success.jsp";
			}
			@Action("foredeleteOrderItem")
			public String deleteOrderItem() {
					orderItemService.delete(orderItem);
					return "success.jsp";
			}
}
