package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.pojo.Product;

public class PropertyValueAction extends Action4Result{
		@Action("admin_listPropertyValue_edit")
		public String edit() {
			product = (Product) productService.get(product.getId());
			propertyValues = propertyValueService.listByParent(product);
			return "listPropertyValue_edit";
		}
}
