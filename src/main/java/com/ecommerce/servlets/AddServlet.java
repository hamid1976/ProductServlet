package com.ecommerce.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.helper.ConnectionProvider;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      //  out.println("<h1>Add Product</h1>");
	      ProductDao dao=new ProductDao(ConnectionProvider.getConnection());
	      
	      out.println("<h1>Add Product</h1>");
	      out.println("<form action=\"AddServlet\" method=\"get\">");
	      out.println("<table border='1'>");
	      out.println("<tr><td>Product Name:</td><td><input type=\"text\" name=\"productName\"></td></tr>");
	      out.println("<tr><td>Price:</td><td><input type=\"text\" name=\"price\"></td></tr>");
	      out.println("<tr><td>Wholesale Price:</td><td><input type=\"text\" name=\"wholesalePrice\"></td></tr>");
	      out.println("<tr><td>Product Type:</td><td><input type=\"text\" name=\"productType\"></td></tr>");
	      out.println("<tr><td>Product Weight:</td><td><input type=\"text\" name=\"productWeight\"></td></tr>");
	      out.println("<tr><td>Product Height:</td><td><input type=\"text\" name=\"productHeight\"></td></tr>");
	      out.println("<tr><td>Quantity:</td><td><input type=\"text\" name=\"quantity\"></td></tr>");
	      out.println("<tr><td>Description:</td><td><input type=\"text\" name=\"description\"></td></tr>");
	      out.println("</table>");
	      out.println("<input type=\"submit\" value=\"Submit\">");
	      out.println("</form>");

	      String productName = request.getParameter("productName");
	      String priceStr = request.getParameter("price");
	      String wholesalePriceStr = request.getParameter("wholesalePrice");
	      String productType = request.getParameter("productType");
	      String productWeight = request.getParameter("productWeight");
	      String productHeight = request.getParameter("productHeight");
	      String quantityStr = request.getParameter("quantity");
	      String description = request.getParameter("description");
	      
	      
        if (productName != null && priceStr != null && wholesalePriceStr != null && productType != null && productWeight != null && productHeight != null && quantityStr != null) {
            try {
                double price = Double.parseDouble(priceStr);
                double wholesalePrice = Double.parseDouble(wholesalePriceStr);
               int quantity = Integer.parseInt(quantityStr);
               
               
          

     	      Product ob1=new Product(productName,price,wholesalePrice,productType,productWeight,productHeight,quantity,description);
     	     dao.addProduct(ob1);
               out.println("Product added successfully.");
           } catch (NumberFormatException e) {
                out.println("Invalid input data.");
            } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        //out.println("<a href=http://localhost:8080/ECommerce/AddServlet>AddProduct</a>");
	    
        out.println("<a href=http://localhost:8080/ECommerce/CRUD>View Products</a>");
         
		
	}


}
