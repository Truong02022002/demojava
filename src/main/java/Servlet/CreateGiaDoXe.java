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
 * Servlet implementation class CreateGiaDoXe
 */
@WebServlet("/CreateGiaDoXe")
public class CreateGiaDoXe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGiaDoXe() {
        super();
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection conn = null;
		
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String time = request.getParameter("time");
			Float price = Float.parseFloat(request.getParameter("price"));
			
			giaDoXe gdx = new giaDoXe(id, name, time, price);
			
			DBUtils.insertGDoXe(conn, gdx);
			
			String context = request.getContextPath();
			response.sendRedirect(context + "/IndexGiaBaiDo");
			
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
