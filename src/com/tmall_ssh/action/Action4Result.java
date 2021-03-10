package com.tmall_ssh.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({

		@Result(name="success.jsp", location="/success.jsp"),
		@Result(name="fail.jsp", location="/fail.jsp"),

		@Result(name = "listCategory",location = "/admin/listCategory.jsp"),
		@Result(name = "listCategory_add",type = "redirect",location = "/admin_listCategory_list"),
		@Result(name = "listCategory_delete",type = "redirect",location="/admin_listCategory_list"),
		@Result(name = "listCategory_edit",location = "/admin/editCategory.jsp"),
		@Result(name = "listCategory_update",type = "redirect",location = "/admin_listCategory_list"),
		
		@Result(name = "listProperty",location = "/admin/listProperty.jsp"),
		@Result(name = "listProperty_edit",location= "/admin/editProperty.jsp"),
		@Result(name = "listProperty_update",type = "redirect",location = "/admin_listProperty_list?category.id=${property.category.id}"),
		@Result(name = "listProperty_delete",type = "redirect",location = "/admin_listProperty_list?category.id=${property.category.id}"),
		@Result(name = "listProperty_add",type= "redirect",location = "/admin_listProperty_list?category.id=${property.category.id}"),
		
		@Result(name = "listProduct",location = "/admin/listProduct.jsp"),
		@Result(name = "listProduct_add",type="redirect",location = "/admin_listProduct_list?category.id=${product.category.id}"),
		@Result(name= "listProduct_edit",location="/admin/editProduct.jsp"),
		@Result(name="listProduct_update",type="redirect",location="/admin_listProduct_list?category.id=${product.category.id}"),
		@Result(name="listProduct_delete",type="redirect",location="/admin_listProduct_list?category.id=${product.category.id}"),
		
		@Result(name="listProductImage_list",location="/admin/listProductImage.jsp"),
		@Result(name="listProductImage_add",type="redirect",location="/admin_listProductImage_list?product.id=${productImage.product.id}"),
		@Result(name="listProductImage_delete",type="redirect",location="/admin_listProductImage_list?product.id=${productImage.product.id}"),
		
		@Result(name="listPropertyValue_edit",location="/admin/editPropertyValue.jsp"),
		@Result(name="listUser_list",location="/admin/listUser.jsp"),
		@Result(name="listOrder_list",location="/admin/listOrder.jsp"),
		@Result(name="home.jsp",location="/home.jsp"),
		@Result(name="register.jsp",location="/register.jsp"),
		@Result(name="registerSuccessPage.jsp",type="redirect",location="/registerSuccess.jsp"),
		@Result(name="login.jsp",location="/login.jsp"),
		@Result(name="product.jsp",location="/product.jsp"),
		@Result(name="homepage",type="redirect",location="/forehome"),
		@Result(name="searchResults.jsp",location="/searchResults.jsp"),
		@Result(name="buyPage.jsp",type="redirect",location="/foreBuy?oiids=${oiid}"),
		@Result(name = "buy.jsp",location="/buy.jsp"),
		@Result(name="cart.jsp",location="/cart.jsp")
})
public class Action4Result extends Action4Parameter {

}
