package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class EditNhanVienServlet
 */
@MultipartConfig(
		 fileSizeThreshold = 1024 * 1024 * 10,
		 maxFileSize = 1024 * 1024 * 50,
		 maxRequestSize = 1024 * 1024 * 100)
@WebServlet("/EditNhanVienServlet")
public class EditNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditNhanVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String errorString = null;
		String id = request.getParameter("id");
		nhanVien nhanv = new nhanVien();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			nhanv = DBUtils.findNV(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("nhanvien", nhanv);
		request.getRequestDispatcher("/EditNhanVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String bdate = request.getParameter("bdate");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String image = "";
			Part filePart = request.getPart("pictureNV");
			String filename = extractFilename(filePart);
			filename = new File(filename).getName();
			filePart.write("C:\\Users\\TRUONG\\Downloads\\cho-Tr-ng-nhanh1\\cho-Tr-ng-nhanh1/src/main/webapp/img" + filename);
			image = "img/" + filename;
			String id_cu = request.getParameter("id_cu");

			nhanVien nhanvien = new nhanVien(id, name, bdate, sex, address, phone, image);

			DBUtils.EditNhanV(conn, nhanvien, id_cu);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/IndexNhanVien");
		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	private String extractFilename (final Part part) {
		String partHeader = part.getHeader("content-disposition");
		for(String content: partHeader.split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 2, content.length() - 1);
			}
		}
		return "";
	}

}
