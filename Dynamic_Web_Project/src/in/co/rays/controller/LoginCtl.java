package in.co.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("Operation");
		String uri = req.getParameter("uri");

		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			
		}

		RequestDispatcher rd = req.getRequestDispatcher("LoginRegistration.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserModel model = new UserModel();
			String login = req.getParameter("loginId");
			String pass = req.getParameter("password");
			String uri = req.getParameter("uri");
			String op = req.getParameter("Operation");

			UserBean bean = model.authenticate(login, pass);

			if (op.equalsIgnoreCase("Login")) {
				if (bean != null) {

				HttpSession session = req.getSession();

				session.setAttribute("fname", bean.getFirstName());

				if (uri.equalsIgnoreCase("null")) {
					RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
					rd.forward(req, resp);
				} else {
					resp.sendRedirect(uri);
				}

			} else {

				req.setAttribute("error", "Invalid Login password");

				RequestDispatcher rd = req.getRequestDispatcher("LoginRegistration.jsp");
				rd.forward(req, resp);
			}  

				
			}
			if (op.equalsIgnoreCase("signup")) {
				resp.sendRedirect("Registration.jsp");
				
			}
		} catch (Exception e) {

		}
		 {
			
		}

	}

}
