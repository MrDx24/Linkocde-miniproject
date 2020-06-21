package com.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);

		LoginDao loginDao = new LoginDao();
		try {

			String result = loginDao.validate(login);
			
			HttpSession session = request.getSession(true);
			if (result=="error-in-login") {
				
				session.setAttribute("error", "Invalid credentials");
			} 
			else {
				String res[] = result.split(" ");
				System.out.println("id : "+res[0] + " || mobile : "+res[1]);
				int resid = Integer.parseInt(res[0]);
				session.setAttribute("userid", resid);
				session.setAttribute("mobile", res[1]);
				response.sendRedirect("Product.jsp");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
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
