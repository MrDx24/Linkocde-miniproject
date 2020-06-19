package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Register;

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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String fullName = request.getParameter("fullname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		
		Register register = new Register();
		register.setFullName(fullName);
		register.setUserName(userName);
		register.setPassword(password);
		register.setMobile(mobile);
		RegisterDao registerDao = new RegisterDao();
		try {
			
			int result = registerDao.saveData(register);
			if (result<=0) {
				System.out.println("Error in Register");
			} 
			else {
				
				System.out.println("Successful");
				response.sendRedirect("Login.jsp");
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
