package com.ecommerce.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;



import com.ecommerce.beans.Product;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.helper.ConnectionProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // out.println("Deleted Successfully");
        ProductDao dao = new ProductDao(ConnectionProvider.getConnection());
        String deleteProductIdStr = request.getParameter("productId");
        // int productId = Integer.parseInt(deleteProductIdStr);

        if (deleteProductIdStr != null) {
            try {
                int deleteProductId = Integer.parseInt(deleteProductIdStr);
                dao.deleteProduct(deleteProductId);

                out.println("Product deleted successfully.");

            } catch (NumberFormatException e) {
                out.println("Invalid Product ID.");
            } catch (Exception e) {
                // Handle any other exceptions here
                e.printStackTrace();
            }

            try {
                // Redirect after successful deletion
                response.sendRedirect("http://localhost:8080/ECommerce/CRUD");
            } catch (IOException e) {
                out.println("Error while redirecting.");
            }
        }
    }
}
