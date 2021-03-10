package com.tmall_ssh.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.ProductImage;
import com.tmall_ssh.service.ProductImageService;
import com.tmall_ssh.util.ImageUtil;

public class ProductImageAction extends Action4Result {
		@Action("admin_listProductImage_list")
		public String list() {
			product = (Product) productService.get(product.getId());
			productSingleImages = productImageService.list("product", product, "type", productImageService.type_single);
			productDetailImages = productImageService.list("product", product, "type", productImageService.type_detail);
			return "listProductImage_list";
		}
		@Action("admin_listProductImage_add")
		public String add() {
		    productImageService.save(productImage);
		    String folder = "img/";
		    if(ProductImageService.type_single.equals(productImage.getType())){
		        folder +="productSingle";
		    }
		    else{
		        folder +="productDetail";
		    }
		    File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath(folder));
		    File file = new File(imageFolder,productImage.getId()+".jpg");
		    String fileName = file.getName();
		    try {
		        FileUtils.copyFile(img, file);
		        BufferedImage img = ImageUtil.change2jpg(file);
		        ImageIO.write(img, "jpg", file);           
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		     
		    if(ProductImageService.type_single.equals(productImage.getType())){
		        String imageFolder_small= ServletActionContext.getServletContext().getRealPath("img/productSingle_small");
		        String imageFolder_middle= ServletActionContext.getServletContext().getRealPath("img/productSingle_middle");       
		        File f_small = new File(imageFolder_small, fileName);
		        File f_middle = new File(imageFolder_middle, fileName);
		        f_small.getParentFile().mkdirs();
		        f_middle.getParentFile().mkdirs();
		        ImageUtil.resizeImage(file, 56, 56, f_small);
		        ImageUtil.resizeImage(file, 217, 190, f_middle);
		    }      
		             
		    return "listProductImage_add";
		}
		@Action("admin_listProductImage_delete")
		public String delete() {
			productImage = (ProductImage)productImageService.get(productImage.getId());
			productImageService.delete(productImage);
			return "listProductImage_delete";
		}
}
