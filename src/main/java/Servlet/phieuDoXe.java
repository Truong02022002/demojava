package Servlet;

public class phieuDoXe {
	
	private String id;
	private String id_xe;
	private String thoi_gian_vao;
	private String thoi_gian_ra;
	private float so_tien;
	public phieuDoXe() {
		super();
	}
	public phieuDoXe(String id) {
		super();
		this.id = id;
	}
	public phieuDoXe(String id, String id_xe, String thoi_gian_vao, String thoi_gian_ra, float so_tien) {
		super();
		this.id = id;
		this.id_xe = id_xe;
		this.thoi_gian_vao = thoi_gian_vao;
		this.thoi_gian_ra = thoi_gian_ra;
		this.so_tien = so_tien;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_xe() {
		return id_xe;
	}
	public void setId_xe(String id_xe) {
		this.id_xe = id_xe;
	}
	public String getThoi_gian_vao() {
		return thoi_gian_vao;
	}
	public void setThoi_gian_vao(String thoi_gian_vao) {
		this.thoi_gian_vao = thoi_gian_vao;
	}
	public String getThoi_gian_ra() {
		return thoi_gian_ra;
	}
	public void setThoi_gian_ra(String thoi_gian_ra) {
		this.thoi_gian_ra = thoi_gian_ra;
	}
	public float getSo_tien() {
		return so_tien;
	}
	public void setSo_tien(float so_tien) {
		this.so_tien = so_tien;
	}
	
}
