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

import com.tmall_ssh.service.OrderService;

@Entity
@Table(name="order_")
public class Order {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		@ManyToOne
		@JoinColumn(name="uid")
		private User user;
		private String orderCode;
	    private String address;
	    private String post;
	    private String receiver;
	    private String mobile;
	    private String userMessage;
	    private Date createDate;
	    private Date payDate;
	    private Date deliveryDate;
	    private Date confirmDate;
	    private String status;
	     
	    @Transient
	    private List<OrderItem> orderItems;
	    @Transient
	    private float total;
	    @Transient
	    private int totalNumber;
	    
	    public String getStatusDesc(){
	        String desc ="δ֪";
	        switch(status){
	            case OrderService.waitPay:
	                desc="����";
	                break;
	            case OrderService.waitDelivery:
	                desc="����";
	                break;
	            case OrderService.waitConfirm:
	                desc="����";
	                break;
	            case OrderService.waitReview:
	                desc="����";
	                break;
	            case OrderService.finish:
	                desc="���";
	                break;
	            case OrderService.delete:
	                desc="�h��";
	                break;
	            default:
	                desc="δ֪";
	        }
	        return desc;
	    }
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getOrderCode() {
			return orderCode;
		}
		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPost() {
			return post;
		}
		public void setPost(String post) {
			this.post = post;
		}
		public String getReceiver() {
			return receiver;
		}
		public void setReceiver(String receiver) {
			this.receiver = receiver;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getUserMessage() {
			return userMessage;
		}
		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Date getPayDate() {
			return payDate;
		}
		public void setPayDate(Date payDate) {
			this.payDate = payDate;
		}
		public Date getDeliveryDate() {
			return deliveryDate;
		}
		public void setDeliveryDate(Date deliveryDate) {
			this.deliveryDate = deliveryDate;
		}
		public Date getConfirmDate() {
			return confirmDate;
		}
		public void setConfirmDate(Date confirmDate) {
			this.confirmDate = confirmDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public List<OrderItem> getOrderItems() {
			return orderItems;
		}
		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
		public float getTotal() {
			return total;
		}
		public void setTotal(float total) {
			this.total = total;
		}
		public int getTotalNumber() {
			return totalNumber;
		}
		public void setTotalNumber(int totalNumber) {
			this.totalNumber = totalNumber;
		}
	    
}
