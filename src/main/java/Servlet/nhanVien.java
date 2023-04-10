package Servlet;

public class nhanVien {
	private String id;
	private String ho_ten;
	private String ngay_sinh;
	private String gioi_tinh;
	private String dia_chi;
	private String sdt;
	private String hinh_anh;
	public nhanVien() {
		super();
	}
	public nhanVien(String id) {
		super();
		this.id = id;
	}
	
	public nhanVien(String id, String ho_ten, String ngay_sinh, String gioi_tinh, String dia_chi, String sdt,
			String hinh_anh) {
		super();
		this.id = id;
		this.ho_ten = ho_ten;
		this.ngay_sinh = ngay_sinh;
		this.gioi_tinh = gioi_tinh;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.hinh_anh = hinh_anh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public String getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public String getGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

	
}
