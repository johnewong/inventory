package inventory;

import java.util.Date;

public class Product {
	private int id;
	private String productName;
	private String type;
	private Date createDate;
	private String macAddr;
	private String status;
	private String soldDate;
	private int cid;
	private String password;
	private String comment;
	private int price;
	private Customer customer;
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getmacAddr() {
		return this.macAddr;
	}
	
	public void setMACAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSoldDate() {
		return this.soldDate;
	}
	
	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}
	
	public int getCid() {
		return this.cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
