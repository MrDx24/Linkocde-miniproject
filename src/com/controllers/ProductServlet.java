package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.model.Order;
import com.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> lst;

	List<Order> lstOrder;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		lst = new ArrayList<>();
		lstOrder = new ArrayList<>();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String productName = request.getParameter("productName");
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		

		HttpSession session = request.getSession(true);
		int id = (int)session.getAttribute("userid");

		try {
			
			Product product = new Product(productName, productQuantity, productPrice);
			ProductDao pd = new ProductDao();
			pd.saveOrder(id, product);

			lstOrder = pd.getOrder(id);
			
			int orderid = lstOrder.get(0).getOrderid();
			session.setAttribute("orderid", orderid);
			session.setAttribute("products", lstOrder);

			response.sendRedirect("Product.jsp");

			
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
