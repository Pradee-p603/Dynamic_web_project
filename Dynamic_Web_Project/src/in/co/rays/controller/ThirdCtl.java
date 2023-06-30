package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ThirdCtl")
public class ThirdCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget of third ctl ");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		
		System.out.println(fname);
		System.out.println(lname);
   RequestDispatcher rd = req.getRequestDispatcher("FourthCtl")	;
   req.setAttribute("key", "here you can set the value in get of third");
   rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost of thirdCtl ");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		System.out.println(fname);
		System.out.println(lname);
		req.setAttribute("ram", "jay shree ram");
		RequestDispatcher rd = req.getRequestDispatcher("FourthCtl");
		rd.forward(req, resp);
		
		
	}
	
}