package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		int accn=Integer.parseInt(request.getParameter("accno"));
		RegisterDao rdao=new RegisterDao();
		int i=rdao.DeleteAccount(accn);
		if(i>0)
		{
			pw.print("<html><body bgcolor='pink'>");
			pw.print("<center><h1><u>Account Deleted</u></h1></center>");
			pw.print("</body></html>");
		}
		else
		{
			pw.print("<html><body bgcolor='pink'>");
			pw.print("<center><h1>....Not Deleted....</h1><br>");
			pw.print("<h4>Enter Valid Account no. to Delete the Data</h4></center>");
			pw.print("</body></html>");
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
