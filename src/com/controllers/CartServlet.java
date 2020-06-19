package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDao;
import com.dao.ProductDao;
import com.model.Bill;
import com.model.Order;
import com.model.Product;

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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HttpSession session = request.getSession(true);
			int id = (int)session.getAttribute("userid");
			int orderid = (int)session.getAttribute("orderid");
			ArrayList<Order> products =  new ArrayList<>();
	
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
//			String res[] = message.split(" ");
//			int bid = Integer.parseInt(res[0]);
//			int rs = Integer.parseInt(res[1]);
			if(message<0){
				System.out.println("Error");
			}
			else {
			
				Bill b = cdao.getBill(orderid, name);
				
				session.setAttribute("bill",b);
				
//				session.setAttribute("billid",bid);
//				
//				session.setAttribute("bname",name);
				
				response.sendRedirect("Bill.jsp");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
/*//
		List<Bill> lst=new ArrayList<>();
		lst.add(b);
		
		ProductDao dobj=new ProductDao();
		int n=dobj.save(lst);
		
		//if(n>0){
			response.sendRedirect("Bill.jsp");
	//	}		else{
			//response.sendRedirect("D.jsp");
		//}
		//		RequestDispatcher rd = request.getRequestDispatcher("Bill.jsp");
//		request.setAttribute("bill",b);
//		rd.forward(request, response);
*/			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
