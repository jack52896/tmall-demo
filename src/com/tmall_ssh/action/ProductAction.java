package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.util.Page;

public class ProductAction extends Action4Result {
		@Action("admin_listProduct_list")
		public String list() {
			if(page == null) {
				page = new Page();
			}
			int total = productService.total();
			page.setTotal(total);
			category = (Category) categoryService.get(category.getId());
			products = productService.list(page, category);
			for(Product product:products) {
				productImageService.setFirstProductImage(product);
			}
			//此时的category中只有id没有name
			System.out.println(category.getId()+"."+category.getName());
			return "listProduct";
		}
		@Action("admin_listProduct_add")
		public String add() {
			productService.save(product);
			return "listProduct_add";
		}
		@Action("admin_listProduct_edit")
		public String edit() {
			product = (Product) productService.get(product.getId());
			return "listProduct_edit";
		}
		@Action("admin_listProduct_update")
		public String update() {
			productService.update(product);
			return "listProduct_update";
		}
		@Action("admin_listProduct_delete")
		public String delete() {
			product=(Product)productService.get(product.getId());
			productService.delete(product);
			return "listProduct_delete";
		}
}
