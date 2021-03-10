package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.pojo.Property;
import com.tmall_ssh.util.Page;
public class PropertyAction extends Action4Result {
			@Action("admin_listProperty_list")
			public String list() {
				if(page == null) {
					page = new Page();
				}
				int total = propertyService.total();
				page.setTotal(total);
				t2p(category);
				propertys = propertyService.list(page, category);
				System.out.println(category.getId()+"."+category.getName());
				return "listProperty";
			}
			@Action("admin_listProperty_edit")
			public String edit() {
				property = (Property) propertyService.get(property.getId());
				return "listProperty_edit";
			}
			@Action("admin_listProperty_update")
			public String update() {
				propertyService.update(property);
				return "listProperty_update";
			}
			@Action("admin_listProperty_delete")
			public String delete() {
				property = (Property) propertyService.get(property.getId());
				propertyService.delete(property);
				return "listProperty_delete";
			}
			@Action("admin_listProperty_add")
			public String add() {
				propertyService.save(property);
				System.out.println(property.getCategory().getName());
				return "listProperty_add";
			}
}
