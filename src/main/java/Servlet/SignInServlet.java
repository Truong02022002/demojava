package Servlet;

import static Servlet.DBUtils.insertNVien;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignInServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Connection conn = null;
		
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			//Xử lý thma số từ form
			String username = request.getParameter("username");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			
			//Tạo đối tượng user
			UserAccount us = new UserAccount(username, phone, password);
			
			//Thêm đối tượng vào cơ sở dữ liệu
			DBUtils.insertUserAccount(conn, us);
			request.setAttribute("name", username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}
	}

}
