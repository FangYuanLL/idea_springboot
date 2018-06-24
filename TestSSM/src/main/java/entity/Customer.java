package entity;

public class Customer {
	int id;
	int flower_id;
	String flower_name;
	int flower_price;
	int updateStatus;
	
	public int getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(int check) {
		this.updateStatus = check;
	}
	public int getFlower_price() {
		return flower_price;
	}
	public void setFlower_price(int flower_price) {
		this.flower_price = flower_price;
	}
	/*public Customer(String flower_name,int flower_id) {
		this.flower_name=flower_name;
		this.flower_id=flower_id;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlower_name() {
		return flower_name;
	}
	public void setFlower_name(String flower_name) {
		this.flower_name = flower_name;
	}
	public int getFlower_id() {
		return flower_id;
	}
	public void setFlower_id(int flower_id) {
		this.flower_id = flower_id;
	}
}
