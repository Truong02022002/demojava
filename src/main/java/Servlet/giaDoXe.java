package Servlet;

public class giaDoXe {
	
	private String id;
	private String name;
	private String time;
	private float price;
	public giaDoXe() {
		super();
	}
	public giaDoXe(String id) {
		super();
		this.id = id;
	}
	public giaDoXe(String id, String name, String time, float price) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
