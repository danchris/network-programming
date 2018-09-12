package thema1;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		String val =  (String) request.getSession().getAttribute("username");
		out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'><title>Register</title></head><body>");
		out.println("<h1>Regiter</h1><form action='Addser' method='post'>Username:	<input id='username' type='text' name='username' value='"+val+"'></input><br>");
		out.println("Full Name: <input id='fName' type='text' name='fName' ></input><br>");
		out.println("Birth: <input id='birth' type='date' name='birth' ></input><br>");
		out.println("Address: <input id='address' type='text' name='address' ></input><br>");
		out.println("<input id='submit' type='submit' value='Submit'></input></form> ");
		out.println("</body></html>");
		out.close();
	}

}
