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
 * Servlet implementation class EditPhieuDoXe
 */
@WebServlet("/EditPhieuDoXe")
public class EditPhieuDoXe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPhieuDoXe() {
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
		String cal = request.getParameter("cal");
		phieuDoXe ph = new phieuDoXe();
		List<xe> pdx = new ArrayList<xe>();
		
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			ph = DBUtils.findPDX(conn, id);
			
			pdx = DBUtils.createShowPDX(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("phieu", ph);
		request.setAttribute("create", pdx);
		request.setAttribute("cal", cal);
		request.getRequestDispatcher("/EditPhieuDoXe.jsp").forward(request, response);

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
			String id_car = request.getParameter("id_car");
			String timeIn = request.getParameter("timeIn");
			String timeOut = request.getParameter("timeOut");
			Float price = Float.parseFloat(request.getParameter("price"));
			String id_cu = request.getParameter("id_cu");


			phieuDoXe phieu = new phieuDoXe(id, id_car, timeIn, timeOut, price);

			DBUtils.EditPhieuDX(conn, phieu, id_cu);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/IndexPhieudoxe");
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
