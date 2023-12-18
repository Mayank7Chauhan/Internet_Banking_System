package com.Controller;
import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.Model.Register;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int accno=Integer.parseInt(request.getParameter("accno"));
		String cname=request.getParameter("custname");
		double acbal=Double.parseDouble(request.getParameter("accbal"));
		String un=request.getParameter("uname");
		String pass=request.getParameter("pass");

		Register reg=new Register();
		reg.setAccno(accno);;
		reg.setCustname(cname);;
		reg.setAccbal(acbal);;
		reg.setUname(un);;
		reg.setPass(pass);
		
		RegisterDao rd=new RegisterDao();
		
		int i=rd.createAccount(reg);
		if(i>0)
		{
			pw.print("<html><body bgcolor='pink'>");
			pw.print("<center><h1><u>Registered Succesfully</u><br>");
			pw.print("<br> <a href=\"Home.html\"> &nbsp&nbsp Back To Home\r\n" + 
					"				&nbsp&nbsp</a></h1></center>");
			pw.print("</body></html>");
			//response.sendRedirect("Home.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 
