package inventory;

import java.util.Date;

public class Item {
	private int id;
	private String name;
	private String description;
	private String category;
	private int safetyStock;
	private int stock;
	private int price;
	private Date createDate;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	public void setCategory(String cate) {
		this.category = cate;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public int getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(int safetyStock) {
		this.safetyStock = safetyStock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
