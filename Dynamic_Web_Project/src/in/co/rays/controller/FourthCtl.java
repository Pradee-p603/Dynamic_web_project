package in.co.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/FourthCtl","/pradeep","*.do"})
public class FourthCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		//String[] address = req.getParameterValues("address");

		System.out.println(fname);
		System.out.println(lname);
		//System.out.println(address[0]);
		//System.out.println(address[1]);
		System.out.println("do get of fourth ctl");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post in FourthCtl");
		String str = (String) req.getAttribute("ram");
		System.out.println(str);
		String str1 = (String) req.getAttribute("shyam");
		System.out.println(str1);
		RequestDispatcher rd = req.getRequestDispatcher("FifthCtl");
		rd.forward(req, resp);

	}

}
