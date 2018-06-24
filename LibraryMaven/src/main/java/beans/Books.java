package beans;

public class Books {
	int id;
	String name;
	int price;
	String publishTime;
	String author;
	public Books(int id,String name,int price,String publishTime,String author) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.publishTime=publishTime;
		this.author=author;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
