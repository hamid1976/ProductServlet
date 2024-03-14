package com.ecommerce.servlets;

import jakarta.servlet.*;

import java.io.*;


import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.helper.ConnectionProvider;

import java.util.*;


public class CRUD extends GenericServlet {
    private static final long serialVersionUID = 1L;

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        ProductDao pDao=new ProductDao(ConnectionProvider.getConnection());
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>E-commerce CRUD Operations</title>");
        out.println("<style>");
        out.println(".input-field { width: 100px; padding: 5px; border: 1px solid #ccc; }");
        out.println(".button { padding: 5px 10px; border: none; cursor: pointer; }");
        out.println(".update-button { background-color: green; color: #fff; }");
        out.println(".delete-button { background-color: red; color: #fff; }");
        out.println("table { border-collapse: collapse; width: 100%; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>E-commerce CRUD Operations</h1>");

        	try {
            List<Product> products = pDao.getAllProducts();
			
        	
            out.println("<h2>Product Details:</h2>");

            out.println("<a href='AddServlet'>Add Product</a>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Product ID</th>");
            out.println("<th>Product Name</th>");
            out.println("<th>Price</th>");
            out.println("<th>Wholesale Price</th>");
            out.println("<th>Product Type</th>");
            out.println("<th>Product Weight</th>");
            out.println("<th>Product Height</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Description</th>");
            out.println("<th>Update</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");

            for (Product product : products) {
                int productIdStr = product.getProductId();
                String productName = product.getProductName();
                double priceStr = product.getPrice();
                double wholesalePriceStr = product.getWholesalePrice();
                String productType = product.getProductType();
                String productWeight = product.getProductWeight();
                String productHeight = product.getProductHeight();
                int quantityStr = product.getQuantity();
                String description = product.getDescription();

                out.println("<tr>");
                out.println("<form action='UpdateServlet' method='get'>");
                out.println("<td><input type='text' name='productId' value='" + productIdStr + "' class='input-field' readonly></td>");
                out.println("<td><input type='text' name='productName' value='" + productName + "' class='input-field'></td>");
                out.println("<td><input type='text' name='price' value='" + priceStr + "' class='input-field'></td>");
                out.println("<td><input type='text' name='wholesalePrice' value='" + wholesalePriceStr + "' class='input-field'></td>");
                out.println("<td><input type='text' name='productType' value='" + productType + "' class='input-field'></td>");
                out.println("<td><input type='text' name='productWeight' value='" + productWeight + "' class='input-field'></td>");
                out.println("<td><input type='text' name='productHeight' value='" + productHeight + "' class='input-field'></td>");
                out.println("<td><input type='text' name='quantity' value='" + quantityStr + "' class='input-field'></td>");
                out.println("<td><input type='text' name='description' value='" + description + "' class='input-field'></td>");
                out.println("<td>");
                out.println("<button type='submit' name='action' value='update' class='button update-button'>Update</button>");
                out.println("</td>");
                out.println("</form>");
                
                out.println("<form action='DeleteServlet' method='get'>");
                out.println("<input type='hidden' name='productId' value='" + productIdStr + "'>");
                out.println("<td><button type='submit' name='action' value='delete' class='button delete-button'>Delete</button></td>");
                out.println("</form>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        	}catch(Exception e) {
        		
        	}
    }
}


