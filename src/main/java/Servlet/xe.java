package Servlet;

public class xe {
	
	private String id;
	private String loaixe;
	private String bienso;
	private String hinhanh;

	public xe() {
		super();
	}
	public xe(String id) {
		super();
		this.id = id;
	}
	public xe(String id, String loaixe, String bienso, String mausac) {
		super();
		this.id = id;
		this.loaixe = loaixe;
		this.bienso = bienso;
		this.hinhanh = mausac;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoaixe() {
		return loaixe;
	}
	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}
	public String getBienso() {
		return bienso;
	}
	public void setBienso(String bienso) {
		this.bienso = bienso;
	}
	public String getMausac() {
		return hinhanh;
	}
	public void setMausac(String mausac) {
		this.hinhanh = mausac;
	}

}
