package com.tmall_ssh.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.service.CategoryService;
import com.tmall_ssh.util.ImageUtil;
import com.tmall_ssh.util.Page;

public class CategoryAction extends Action4Result{
		
		@Action("admin_listCategory_list")
		public String list() {
			if(page ==null) {
				page = new Page();
			}
			int total = categoryService.total();
			page.setTotal(total);
			categorys = categoryService.listByPage(page);
			return "listCategory";
		}
		@Action("admin_listCategory_add")
		public String add() {
			categoryService.save(category);
			File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
	        File file = new File(imageFolder,category.getId()+".jpg");
	        try {
	            FileUtils.copyFile(img, file);
	            BufferedImage img = ImageUtil.change2jpg(file);
	            ImageIO.write(img, "jpg", file);           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "listCategory_add";
		}
		@Action("admin_listCategory_delete")
		public String delete() {
			this.t2p(category);
			categoryService.delete(category);
			return "listCategory_delete";
		}
		@Action("admin_listCategory_edit")
		public String edit() {
			int cid = category.getId();
			category = (Category)categoryService.get(cid);
			return "listCategory_edit";
		}
		@Action("admin_listCategory_update")
		public String update() {
			categoryService.update(category);
			return "listCategory_update";
		}
}
