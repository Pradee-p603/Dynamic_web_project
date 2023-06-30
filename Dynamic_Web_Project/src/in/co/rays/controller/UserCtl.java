package in.co.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl.do")

public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserModel model = new UserModel();
		try {
			UserBean bean = model.findByPk(Integer.parseInt(id));
			req.setAttribute("bean", bean);

			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("Operation");
		String id = req.getParameter("id");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");

		UserBean Bean = new UserBean();
		Bean.setFirstName(fname);
		Bean.setLastName(lname);
		Bean.setLoginId(login);
		Bean.setPassword(pass);
		Bean.setAddress(address);

		UserModel model = new UserModel();

		if (op.equals("signup")) {
			try {
				model.add(Bean);
				resp.sendRedirect("UserListCtl.do");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (op.equals("Update")) {
			Bean.setId(Integer.parseInt(id));
			try {
				UserBean bean = (UserBean) model.Update(Bean);
				resp.sendRedirect("UserListCtl.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
