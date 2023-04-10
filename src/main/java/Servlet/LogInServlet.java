package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogInServlet() {
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
		Connection conn;
		
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			
			//Xử lý tham số từ form
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//Tạo đối tượng csdl
			UserAccount us = new UserAccount(username, password);
			//Thêm đối tượng vào csdl
			UserAccount n = DBUtils.findUS(conn, us.getUsername(), us.getPassword());
			
			if(n != null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				UserAccount usr = new UserAccount();
				request.setAttribute("nhanvien", "Hi, " + username + " !");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				
				//request.getRequestDispatcher("/LogIn.jsp".forward(request,response);)
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()) {
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Thông báo</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>Thông báo thông tin đăng nhập không chính xác<a href= LogIn.jsp>Nhập lại</a></h1>");
					out.println("</body>");
					out.println("</html>");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, e);
		}
		
		
	}

}
