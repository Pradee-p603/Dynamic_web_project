package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FirstCtl")
public class FirstCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get in FirstCtl");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		System.out.println(fname);
		System.out.println(lname);
	     resp.sendRedirect("SecondCtl");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post in firstCtl");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		System.out.println(fname);
		System.out.println(lname);
		resp.sendRedirect("SecondCtl");
	
		
	}

}
