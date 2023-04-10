package Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "insert into useraccount(username, phone, password) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPhone());
		pstm.setString(3, user.getPassword());

		pstm.executeUpdate();
	}

	public static void insertNVien(Connection conn, nhanVien nv) throws SQLException {
		String sql = "insert into nhanvien(id, ho_ten, ngay_sinh, gioi_tinh, dia_chi, sdt, hinh_anh)"
				+ " values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, nv.getId());
		pstm.setString(2, nv.getHo_ten());
		pstm.setString(3, nv.getNgay_sinh());
		pstm.setString(4, nv.getGioi_tinh());
		pstm.setString(5, nv.getDia_chi());
		pstm.setString(6, nv.getSdt());
		pstm.setString(7, nv.getHinh_anh());

		pstm.executeUpdate();
	}
	
	public static void insertGDoXe(Connection conn, giaDoXe gdx) throws SQLException {
		String sql = "insert into gia_do_xe(id, loai_xe, thoi_gian, gia) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, gdx.getId());
		pstm.setString(2, gdx.getName());
		pstm.setString(3, gdx.getTime());
		pstm.setFloat(4, gdx.getPrice());

		pstm.executeUpdate();
	}
	
	public static void insertXe(Connection conn, xe x) throws SQLException {
		String sql = "insert into xe(id, loai_xe, bien_so, hinh_anh) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, x.getId());
		pstm.setString(2, x.getLoaixe());
		pstm.setString(3, x.getBienso());
		pstm.setString(4, x.getMausac());

		pstm.executeUpdate();
	}
	
	public static void insertPDXe(Connection conn, phieuDoXe pdx) throws SQLException {
		String sql = "insert into phieu_do_xe(id, id_xe, thoi_gian_vao, thoi_gian_ra, so_tien) values (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, pdx.getId());
		pstm.setString(2, pdx.getId_xe());
		pstm.setString(3, pdx.getThoi_gian_vao());
		pstm.setString(4, pdx.getThoi_gian_ra());
		pstm.setFloat(5, pdx.getSo_tien());

		pstm.executeUpdate();
	}

	public static UserAccount findUS(Connection conn, String username, String password) throws SQLException {
		String sql = "select username, password from useraccount where username = ? and password = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			UserAccount us = new UserAccount();
			us.setUsername(username);
			us.setPassword(password);
			return us;
		}
		return null;
	}

	public static nhanVien findNV(Connection conn, String id) throws SQLException {
		String sql = "select * from nhanvien where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			nhanVien nv = new nhanVien();
			String iden = rs.getString("id");
			String name = rs.getString("ho_ten");
			String bdate = rs.getString("ngay_sinh");
			String sex = rs.getString("gioi_tinh");
			String addr = rs.getString("dia_chi");
			String phone = rs.getString("sdt");
			String img = rs.getString("hinh_anh");
			
			nv.setId(iden);
			nv.setHo_ten(name);
			nv.setNgay_sinh(bdate);
			nv.setGioi_tinh(sex);
			nv.setDia_chi(addr);
			nv.setSdt(phone);
			nv.setHinh_anh(img);

			return nv;
		}
		return null;
	}
	
	public static giaDoXe findGDX(Connection conn, String id) throws SQLException {
		String sql = "select * from gia_do_xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			giaDoXe giad = new giaDoXe();
			String iden = rs.getString("id");
			String name = rs.getString("loai_xe");
			String time = rs.getString("thoi_gian");
			Float price = rs.getFloat("gia");
			
			giad.setId(iden);
			giad.setName(name);
			giad.setTime(time);
			giad.setPrice(price);

			return giad;
		}
		return null;
	}
	
	public static xe findXe(Connection conn, String id) throws SQLException {
		String sql = "select * from xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			xe x = new xe();
			String iden = rs.getString("id");
			String catagory = rs.getString("loai_xe");
			String seanum = rs.getString("bien_so");
			String color = rs.getString("hinh_anh");
			
			x.setId(iden);
			x.setLoaixe(catagory);
			x.setBienso(seanum);
			x.setMausac(color);
		
			return x;
		}
		return null;
	}
	
	public static phieuDoXe findPDX(Connection conn, String id) throws SQLException {
		String sql = "select * from phieu_do_xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			phieuDoXe phieudx = new phieuDoXe();
			String iden = rs.getString("id");
			String idenXe = rs.getString("id_xe");
			String timeIn = rs.getString("thoi_gian_vao");
			String timeOut = rs.getString("thoi_gian_ra");
			Float price = rs.getFloat("so_tien");
			
			phieudx.setId(iden);
			phieudx.setId_xe(idenXe);
			phieudx.setThoi_gian_vao(timeIn);
			phieudx.setThoi_gian_ra(timeOut);
			phieudx.setSo_tien(price);

			return phieudx;
		}
		return null;
	}
	
	public static void EditNhanV(Connection conn, nhanVien nv, String id) throws SQLException {
		String sql = "update nhanvien set id = ?, ho_ten = ?, ngay_sinh = ?, gioi_tinh = ?, dia_chi = ?,"
				+ "sdt = ?, hinh_anh = ? where id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, nv.getId());
		pstm.setString(2, nv.getHo_ten());
		pstm.setString(3, nv.getNgay_sinh());
		pstm.setString(4, nv.getGioi_tinh());
		pstm.setString(5, nv.getDia_chi());
		pstm.setString(6, nv.getSdt());
		pstm.setString(7, nv.getHinh_anh());
		pstm.setString(8, id);

		pstm.executeUpdate();
	}

	public static void EditGiaDX(Connection conn, giaDoXe gdx) throws SQLException {
		String sql = "update gia_do_xe set loai_xe = ?, thoi_gian = ?, gia = ?"
				+ " where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, gdx.getName());
		pstm.setString(2, gdx.getTime());
		pstm.setFloat(3, gdx.getPrice());
		pstm.setString(4, gdx.getId());

		pstm.executeUpdate();
	}
	
	public static void EditXe(Connection conn, xe x) throws SQLException {
		String sql = "update xe set loai_xe = ?, bien_so = ?, hinh_anh = ?"
				+ "where id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, x.getLoaixe());
		pstm.setString(2, x.getBienso());
		pstm.setString(3, x.getMausac());
		pstm.setString(4, x.getId());

		pstm.executeUpdate();
	}
	
	public static void EditPhieuDX(Connection conn, phieuDoXe pdx, String id) throws SQLException {
		String sql = "update phieu_do_xe set id = ?, id_xe = ?, thoi_gian_vao = ?, thoi_gian_ra = ?"
				+ ", so_tien = ? where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, pdx.getId());
		pstm.setString(2, pdx.getId_xe());
		pstm.setString(3, pdx.getThoi_gian_vao());
		pstm.setString(4, pdx.getThoi_gian_ra());
		pstm.setFloat(5, pdx.getSo_tien());
		pstm.setString(6, id);

		pstm.executeUpdate();
	}
	
	public static void DeleteNhanV(Connection conn, nhanVien nv) throws SQLException {
		String sql = "delete from nhanvien where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, nv.getId());

		pstm.executeUpdate();
	}
	
	public static void DeleteGiaDX(Connection conn, giaDoXe gdx) throws SQLException {
		String sql = "delete from gia_do_xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, gdx.getId());

		pstm.executeUpdate();
	}
	
	public static void DeleteXe(Connection conn, xe x) throws SQLException {
		String sql = "delete from xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, x.getId());

		pstm.executeUpdate();
	}
	
	public static void DeletePhieuDX(Connection conn, phieuDoXe pdx) throws SQLException {
		String sql = "delete from phieu_do_xe where id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, pdx.getId());

		pstm.executeUpdate();
	}

	public static List<nhanVien> searchNV(Connection conn, String name) throws SQLException {

		String sql = "select * from nhanvien where ho_ten like ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		List<nhanVien> NV = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String hoten = rs.getString("ho_ten");
			String bdate = rs.getString("ngay_sinh");
			String sex = rs.getString("gioi_tinh");
			String addr = rs.getString("dia_chi");
			String phone = rs.getString("sdt");	
			String img = rs.getString("hinh_anh");

			nhanVien nhanv = new nhanVien();
			nhanv.setId(id);
			nhanv.setHo_ten(hoten);
			nhanv.setNgay_sinh(bdate);
			nhanv.setGioi_tinh(sex);
			nhanv.setDia_chi(addr);
			nhanv.setSdt(phone); 
			nhanv.setHinh_anh(img);
			NV.add(nhanv);

		}

		return NV;
	}
	
	public static List<giaDoXe> searchGDX(Connection conn, String name) throws SQLException {

		String sql = "select * from gia_do_xe where loai_xe like ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		List<giaDoXe> DX = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String loaixe = rs.getString("loai_xe");
			String time = rs.getString("thoi_gian");
			Float price = rs.getFloat("gia");		

			giaDoXe gdx = new giaDoXe();
			gdx.setId(id);
			gdx.setName(loaixe);
			gdx.setTime(time);
			gdx.setPrice(price);
			DX.add(gdx);

		}

		return DX;
	}
	
	public static List<xe> searchX(Connection conn, String name) throws SQLException {

		String sql = "select * from xe where loai_xe like ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		List<xe> X = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String loaixe = rs.getString("loai_xe");
			String seanum = rs.getString("bien_so");		
			String color = rs.getString("hinh_anh");	

			xe x = new xe();
			x.setId(id);
			x.setLoaixe(loaixe);
			x.setBienso(seanum);
			x.setMausac(color);
			X.add(x);

		}

		return X;
	}
	
	public static List<phieuDoXe> searchPDX(Connection conn, String name) throws SQLException {

		String sql = "select * from phieu_do_xe where id_xe like ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + name + "%");
		ResultSet rs = pstm.executeQuery();
		List<phieuDoXe> PDX = new ArrayList<>();

		while (rs.next()) {
			
			String iden = rs.getString("id");
			String idenXe = rs.getString("id_xe");
			String timeIn = rs.getString("thoi_gian_vao");
			String timeOut = rs.getString("thoi_gian_ra");
			Float price = rs.getFloat("so_tien");
			
			phieuDoXe phieudx = new phieuDoXe();
			phieudx.setId(iden);
			phieudx.setId_xe(idenXe);
			phieudx.setThoi_gian_vao(timeIn);
			phieudx.setThoi_gian_ra(timeOut);
			phieudx.setSo_tien(price);
			PDX.add(phieudx);

		}

		return PDX;
	}	

	public static int countNV(Connection conn) throws SQLException {

		String sql = "select count(*) from nhanvien ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {

			return rs.getInt(1);
		}

		return 0;
	}
	
	public static int countGDX(Connection conn) throws SQLException {

		String sql = "select count(*) from gia_do_xe ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {

			return rs.getInt(1);
		}

		return 0;
	}
	
	public static int countXe(Connection conn) throws SQLException {

		String sql = "select count(*) from xe ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {

			return rs.getInt(1);
		}

		return 0;
	}
	
	public static int countPDX(Connection conn) throws SQLException {

		String sql = "select count(*) from phieu_do_xe ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {

			return rs.getInt(1);
		}

		return 0;
	}

	public static List<nhanVien> WrapPageNV(Connection conn, int PageStart, int PageIndex) throws SQLException {

		String sql = "select * from nhanvien LIMIT ?,?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, PageStart);
		pstm.setInt(2, PageIndex);
		ResultSet rs = pstm.executeQuery();
		List<nhanVien> NV = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String hoten = rs.getString("ho_ten");
			String bdate = rs.getString("ngay_sinh");
			String sex = rs.getString("gioi_tinh");
			String addr = rs.getString("dia_chi");
			String phone = rs.getString("sdt");
			String img = rs.getString("hinh_anh");

			nhanVien nhanv = new nhanVien();
			nhanv.setId(id);
			nhanv.setHo_ten(hoten);
			nhanv.setNgay_sinh(bdate);
			nhanv.setGioi_tinh(sex);
			nhanv.setDia_chi(addr);
			nhanv.setSdt(phone); 
			nhanv.setHinh_anh(img);
			NV.add(nhanv);
		}

		return NV;
	}
	
	public static List<giaDoXe> WrapPageGDX(Connection conn, int PageStart, int PageIndex) throws SQLException {

		String sql = "select * from gia_do_xe LIMIT ?,?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, PageStart);
		pstm.setInt(2, PageIndex);
		ResultSet rs = pstm.executeQuery();
		List<giaDoXe> DX = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String loaixe = rs.getString("loai_xe");
			String time = rs.getString("thoi_gian");
			Float price = rs.getFloat("gia");		

			giaDoXe gdx = new giaDoXe();
			gdx.setId(id);
			gdx.setName(loaixe);
			gdx.setTime(time);
			gdx.setPrice(price);
			DX.add(gdx);

		}

		return DX;
	}
	
	public static List<xe> WrapPageX(Connection conn, int PageStart, int PageIndex) throws SQLException {

		String sql = "select * from xe LIMIT ?,?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, PageStart);
		pstm.setInt(2, PageIndex);
		ResultSet rs = pstm.executeQuery();
		List<xe> X = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");
			String loaixe = rs.getString("loai_xe");
			String seanum = rs.getString("bien_so");		
			String color = rs.getString("hinh_anh");	
		
			xe xe = new xe();
			xe.setId(id);
			xe.setLoaixe(loaixe);
			xe.setBienso(seanum);
			xe.setMausac(color);
			X.add(xe);

		}

		return X;
	}
	
	public static List<phieuDoXe> WrapPagePDX(Connection conn, int PageStart, int PageIndex) throws SQLException {

		String sql = "select * from phieu_do_xe LIMIT ?,?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, PageStart);
		pstm.setInt(2, PageIndex);
		ResultSet rs = pstm.executeQuery();
		List<phieuDoXe> PDX = new ArrayList<>();

		while (rs.next()) {
			String iden = rs.getString("id");
			String idenXe = rs.getString("id_xe");
			String timeIn = rs.getString("thoi_gian_vao");
			String timeOut = rs.getString("thoi_gian_ra");
			Float price = rs.getFloat("so_tien");
			
			phieuDoXe phieudx = new phieuDoXe();
			phieudx.setId(iden);
			phieudx.setId_xe(idenXe);
			phieudx.setThoi_gian_vao(timeIn);
			phieudx.setThoi_gian_ra(timeOut);
			phieudx.setSo_tien(price);
			PDX.add(phieudx);

		}

		return PDX;
	}
	
	public static List<xe> createShowPDX(Connection conn) throws SQLException {

		String sql = "select id from xe";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<xe> X = new ArrayList<>();

		while (rs.next()) {
			String idenXe = rs.getString("id");
			
			xe x = new xe(idenXe);
			x.setId(idenXe);
			X.add(x);
		}

		return X;
	}
	
	public static List<giaDoXe> createShowX(Connection conn) throws SQLException {

		String sql = "select id from gia_do_xe";

		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<giaDoXe> DX = new ArrayList<>();

		while (rs.next()) {
			String id = rs.getString("id");	

			giaDoXe gdx = new giaDoXe();
			gdx.setId(id);
			DX.add(gdx);
		}

		return DX;
	}
	
}