package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FifthCtl")
public class FifthCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget of 4th ctl ");
	String fname =	req.getParameter("firstName");
	String lname = req.getParameter("lastName");
	System.out.println(fname);
	System.out.println(lname);
	req.setAttribute("ram", "hello jay shree ram");
	RequestDispatcher rd = req.getRequestDispatcher("ThirdCtl");
	rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post of 5th ctl ");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		
		System.out.println(fname);
		System.out.println(lname);
		req.setAttribute("shyam", " jay shree shyam");
		RequestDispatcher rd = req.getRequestDispatcher("ThirdCtl");
		rd.forward(req, resp);
		
		
	}

}
