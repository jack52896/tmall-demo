package com.tmall_ssh.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product_")
public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		@ManyToOne   
		@JoinColumn(name = "cid")
		private Category category;
		@Column(name = "name")
		private String name;
		@Column(name="subTitle")
	    private String subTitle;
		@Column(name="originalPrice")
	    private float originalPrice;
		@Column(name="promotePrice")
	    private float promotePrice;
		@Column(name="stock")
	    private int stock;
		@Column(name="createDate")
	    private Date createDate;
		
		@Transient
		private ProductImage firstProductImage;
		@Transient
		private List<ProductImage> productSingleImages;
		@Transient
		private List<ProductImage> productDetailImages; 
		@Transient
		private int saleCount;
		@Transient
		private int reviewCount;
		
		
		public int getSaleCount() {
			return saleCount;
		}
		public void setSaleCount(int saleCount) {
			this.saleCount = saleCount;
		}
		public int getReviewCount() {
			return reviewCount;
		}
		public void setReviewCount(int reviewCount) {
			this.reviewCount = reviewCount;
		}
		public List<ProductImage> getProductSingleImages() {
			return productSingleImages;
		}
		public void setProductSingleImages(List<ProductImage> productSingleImages) {
			this.productSingleImages = productSingleImages;
		}
		public List<ProductImage> getProductDetailImages() {
			return productDetailImages;
		}
		public void setProductDetailImages(List<ProductImage> productDetailImages) {
			this.productDetailImages = productDetailImages;
		}
		public ProductImage getFirstProductImage() {
			return firstProductImage;
		}
		public void setFirstProductImage(ProductImage firstProductImage) {
			this.firstProductImage = firstProductImage;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSubTitle() {
			return subTitle;
		}
		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}
		public float getOriginalPrice() {
			return originalPrice;
		}
		public void setOriginalPrice(float originalPrice) {
			this.originalPrice = originalPrice;
		}
		public float getPromotePrice() {
			return promotePrice;
		}
		public void setPromotePrice(float promotePrice) {
			this.promotePrice = promotePrice;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", category=" + category + ", name=" + name + ", subTitle=" + subTitle
					+ ", originalPrice=" + originalPrice + ", promotePrice=" + promotePrice + ", stock=" + stock
					+ ", createDate=" + createDate + "]";
		}
		
	    
}
