package com.tmall_ssh.action;

import java.util.List;

import com.tmall_ssh.pojo.Category;
import com.tmall_ssh.pojo.Order;
import com.tmall_ssh.pojo.OrderItem;
import com.tmall_ssh.pojo.Product;
import com.tmall_ssh.pojo.ProductImage;
import com.tmall_ssh.pojo.Property;
import com.tmall_ssh.pojo.PropertyValue;
import com.tmall_ssh.pojo.Review;
import com.tmall_ssh.pojo.User;
import com.tmall_ssh.util.Param;

public class Action4Pojo extends Action4Pagination {
	protected Category category;
    
    protected List<Category> categorys;
    
    protected Property property;
    
    protected List<Property> propertys;
    
    protected Product product;
    
    protected List<Product> products;
        
    protected List<ProductImage> productSingleImages;
    protected List<ProductImage> productDetailImages;

	protected ProductImage productImage;
	
	protected PropertyValue propertyValue;
	
	protected List<PropertyValue> propertyValues;
	
	protected User user;
	
	protected List<User> users;
	
	protected Order order;
	
	protected List<Order> orders;
	
	protected OrderItem orderItem;
	
	protected List<OrderItem> orderItems;
	protected List<Review> reviews;
	protected Param param;
	
	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public PropertyValue getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(PropertyValue propertyValue) {
		this.propertyValue = propertyValue;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public List<Category> getCategorys() {
        return categorys;
    }
 
    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }
}
