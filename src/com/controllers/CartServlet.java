package com.controllers;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDao;

import com.model.Bill;
import com.model.Order;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			HttpSession session = request.getSession(true);
			int id = (int)session.getAttribute("userid");
			int orderid = (int)session.getAttribute("orderid");
			ArrayList<Order> products =  new ArrayList<Order>();
	
			products = (ArrayList)session.getAttribute("products");
			
			CartDao cdao = new CartDao();
	
			double total=0,gst,finalTotal;
			String name = cdao.getName(id);
	
			for(Order p:products){
				total=total+(p.getProductPrice()*p.getProductQuantity());
			}
			gst=total*0.12;
			finalTotal=gst+total;
	
			Bill bill=new Bill(name, total, gst, gst, finalTotal);
			int message = cdao.saveBill(id, orderid, bill);

			if(message<0){
				
				session.setAttribute("billerror","Bill Error");	
			}
			else {
			
				Bill b = cdao.getBill(orderid, name);
				session.setAttribute("bill",b);				
				response.sendRedirect("Bill.jsp");
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
