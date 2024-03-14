package com.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;

import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.helper.ConnectionProvider;


public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      ProductDao dao=new ProductDao(ConnectionProvider.getConnection());
        
      String productIdStr = request.getParameter("productId");
      String productName = request.getParameter("productName");
      String priceStr = request.getParameter("price");
      String wholesalePriceStr = request.getParameter("wholesalePrice");
      String productType = request.getParameter("productType");
      String productWeight = request.getParameter("productWeight");
      String productHeight = request.getParameter("productHeight");
      String quantityStr = request.getParameter("quantity");
      String description = request.getParameter("description");
        try {
        	
	            int productId = Integer.parseInt(productIdStr);
	            double price = Double.parseDouble(priceStr);
	            double wholesaleprice = Double.parseDouble(wholesalePriceStr);
	            int quantity = Integer.parseInt(quantityStr);
                try {
                	Product ob=new Product(productName,price,wholesaleprice,productType,productWeight,productHeight,quantity,description);
                    dao.updateProduct(ob,productId);
                    out.println("Product updated successfully.");
                } catch (NumberFormatException e) {
                    out.println("Invalid input. Please provide valid numeric values.");
                } catch (Exception e) {
                out.println("An error occurred while updating the product.");
                    e.printStackTrace(); 
                }
         
        } catch (NumberFormatException e) {
            out.println("Invalid product ID. Please provide a valid numeric value.");
        } catch (Exception e) {
       
            out.println("An error occurred while processing the request.");
            e.printStackTrace(); 
        }
        try {
            response.sendRedirect("http://localhost:8080/WebProj/CRUD");
        } catch (IOException e) {
            out.println("Error while redirecting.");
        }
    }
}

