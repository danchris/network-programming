package thema1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String username = request.getParameter("username");
		 
		String password = request.getParameter("password");
		if (username.equals("ntua") && password.equals("ntua"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("servlet_welcome.jsp");
			
		}
		else
		{
			request.setAttribute("message", "Account is invalid");
			request.getRequestDispatcher("servlet_login.jsp").forward(request, response);
		}
		*/
		String in = request.getParameter("username");
		request.getSession().setAttribute("username", in);
		System.out.println("EEEEEEEEEEe== " + in);
		PrintWriter out;
		out = response.getWriter();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/account","root","");
			System.out.println(con);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM selection WHERE username='"+in+"';");
			
			if(rs.next()){
				System.out.println("yea");
				
				
				out.println("<html><head><title>MyAccount</title></head>");
				out.println("<body><h1>MyAccount</h1><ol><li>Username: '"+in+"'</li>");
				out.println("<li>FullName: '"+rs.getString("fullName")+"'</li>");
				out.println("<li>Birth: '"+rs.getString("birth")+"'</li>'");
				out.println("<li>Address: '"+rs.getString("address")+"'</li>'");
				out.println("</ol>");
				out.println("</body></html>");
				out.close();
				
			}
			else{
				System.out.println("no");
				response.sendRedirect("Add");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
