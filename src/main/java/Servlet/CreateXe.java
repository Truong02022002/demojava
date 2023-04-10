package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateXe
 */
@WebServlet("/CreateXe")
public class CreateXe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateXe() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<giaDoXe> x = new ArrayList<giaDoXe>();
		
		Connection conn;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			x = DBUtils.createShowX(conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("create", x);
		request.getRequestDispatcher("/AddXe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = null;

		try {
			conn = MySQLConntUtils.getMySQLConnection();

			String id = request.getParameter("id");
			String catagory = request.getParameter("catagory");
			String seanum = request.getParameter("seanum");
			String color = request.getParameter("color");
			String state = request.getParameter("state");
			
			xe nhanv = new xe(id, catagory, seanum, color);

			DBUtils.insertXe(conn, nhanv);

			String context = request.getContextPath();
			response.sendRedirect(context + "/IndexXe");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, e);
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

}
