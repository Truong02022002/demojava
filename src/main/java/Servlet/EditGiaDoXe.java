package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditGiaDoXe
 */
@WebServlet("/EditGiaDoXe")
public class EditGiaDoXe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGiaDoXe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String errorString = null;
		String id = request.getParameter("id");
		giaDoXe giaDX = new giaDoXe();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			giaDX = DBUtils.findGDX(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("gia", giaDX);
		request.getRequestDispatcher("/EditGiaDoXe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();

			String id = request.getParameter("id_cu");
			String name = request.getParameter("name");
			String time = request.getParameter("time");
			Float price = Float.parseFloat(request.getParameter("price"));

			giaDoXe giadx = new giaDoXe(id, name, time, price);

			DBUtils.EditGiaDX(conn, giadx);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/IndexGiaBaiDo");
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

}
