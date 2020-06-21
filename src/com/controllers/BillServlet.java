package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BillDao;
import com.model.Bill;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		
		int userid = (int) session.getAttribute("userid");
		String mobile = (String) session.getAttribute("mobile");

		try {
			
			BillDao bdao = new BillDao();
			int res = bdao.placeOrder(userid);
			if (res<0) {
				session.setAttribute("Errorinbillservlet", "Error-in-billservlet");
				
			} else {
				Bill b = (Bill) session.getAttribute("bill");
				String bill = Double.toString(b.getFinalBill());
				bdao.sendSms("Stampy - Your order is placed succesfully of amount : Rs " + bill, mobile);
				
				session.setAttribute("session", session);
				response.sendRedirect("PlaceOrder.jsp");
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
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
