package com.tmall_ssh.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "category_")
public class Category {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id")
			private int id;
			private String name;
			@Transient
			private List<Product> products;
			@Transient
			private List<List<Product>> productByRow;
			
			
			public List<Product> getProducts() {
				return products;
			}
			public void setProducts(List<Product> products) {
				this.products = products;
			}
			public List<List<Product>> getProductByRow() {
				return productByRow;
			}
			public void setProductByRow(List<List<Product>> productByRow) {
				this.productByRow = productByRow;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			@Override
			public String toString() {
				return "Category [id=" + id + ", name=" + name + "]";
			}
}
