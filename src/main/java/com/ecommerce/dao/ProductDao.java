package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ecommerce.beans.Product;
import com.ecommerce.helper.ConnectionProvider;
public class ProductDao {
	
	private  final Connection con;
	
	public ProductDao(Connection con){
		
		this.con=con;
	}
	
	 public  List<Product> getAllProducts() throws Exception {
		    String query = "select * from products";
		    System.out.println(query);
		    Statement st = null;
		    ResultSet result = null;
		
		    try {
		        try {
					try {
						st = con.createStatement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        result = st.executeQuery(query);
		        List<Product> beans=new ArrayList();
		
		        while (result.next()) {
		            Product bean = new Product();
		            bean.setProductId(result.getInt("product_id"));
		            bean.setProductName(result.getString("product_name"));
		            bean.setPrice(result.getDouble("price"));
		            bean.setWholesalePrice(result.getDouble("wholesale_price"));
		            bean.setProductType(result.getString("product_type"));
		            bean.setProductWeight(result.getString("product_weight"));
		            bean.setProductHeight(result.getString("product_height"));
		            bean.setQuantity(result.getInt("quantity"));
		            bean.setDescription(result.getString("description"));
		
		            // Print the values of all columns
		            System.out.println("Product ID: " + bean.getProductId());
		            System.out.println("Product Name: " + bean.getProductName());
		            System.out.println("Price: " + bean.getPrice());
		            System.out.println("Wholesale Price: " + bean.getWholesalePrice());
		            System.out.println("Product Type: " + bean.getProductType());
		            System.out.println("Product Weight: " + bean.getProductWeight());
		            System.out.println("Product Height: " + bean.getProductHeight());
		            System.out.println("Quantity: " + bean.getQuantity());
		            System.out.println("Description: " + bean.getDescription());
		            
		            System.out.println("*****************************************");
		            
		           beans.add(bean);
		        }
		        return beans;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        try {
		            if (result != null)
		                result.close();
		            if (st != null)
		                st.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		}//end getAllProducts

	    public  Product getProductById(int productId) throws Exception {
		    String query = "select * from products where product_id=" + productId;
		    System.out.println(query);
		    Statement st = null;
		    ResultSet result = null;
		
		    try {
		        st = con.createStatement();
		        result = st.executeQuery(query);
		
		        if (result.next()) {
		            Product bean = new Product();
		            bean.setProductId(result.getInt("product_id"));
		            bean.setProductName(result.getString("product_name"));
		            bean.setPrice(result.getDouble("price"));
		            bean.setWholesalePrice(result.getDouble("wholesale_price"));
		            bean.setProductType(result.getString("product_type"));
		            bean.setProductWeight(result.getString("product_weight"));
		            bean.setProductHeight(result.getString("product_height"));
		            bean.setQuantity(result.getInt("quantity"));
		            bean.setDescription(result.getString("description"));
		
		            // Print the values of all columns
		            System.out.println("Product ID: " + bean.getProductId());
		            System.out.println("Product Name: " + bean.getProductName());
		            System.out.println("Price: " + bean.getPrice());
		            System.out.println("Wholesale Price: " + bean.getWholesalePrice());
		            System.out.println("Product Type: " + bean.getProductType());
		            System.out.println("Product Weight: " + bean.getProductWeight());
		            System.out.println("Product Height: " + bean.getProductHeight());
		            System.out.println("Quantity: " + bean.getQuantity());
		            System.out.println("Description: " + bean.getDescription());
		
		            return bean;
		        }
		        return null; // Return null if no product with the specified ID was found
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        try {
		            if (result != null)
		                result.close();
		            if (st != null)
		                st.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		}//end getProductById


	    public int addProduct(Product pro) throws Exception {
	        String query = "INSERT INTO products (product_name, price, wholesale_price, product_type, product_weight, product_height, quantity, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        System.out.println(query);
	        

	        PreparedStatement ps = null;
	        try {
	            ps = con.prepareStatement(query);
	            ps.setString(1, pro.getProductName());
	            ps.setDouble(2, pro.getPrice());
	            ps.setDouble(3, pro.getWholesalePrice());
	            ps.setString(4, pro.getProductType());
	            ps.setString(5, pro.getProductWeight());
	            ps.setString(6, pro.getProductHeight());
	            ps.setInt(7, pro.getQuantity());
	            ps.setString(8, pro.getDescription());

	            int rows = ps.executeUpdate();
	            return rows;
	        } finally {
	            if (ps != null) {
	                ps.close();
	            }
	        }
	    }

	    public int updateProduct(Product pro,int productId) throws Exception {
	        String query = "UPDATE products SET product_name=?, price=?, wholesale_price=?, product_type=?, product_weight=?, product_height=?, quantity=?, description=? WHERE product_id=?";
	        System.out.println(query);

	        PreparedStatement ps = null;
	        int rowsUpdated = 0;

	        try {
	            ps = con.prepareStatement(query);
	            ps.setString(1, pro.getProductName());
	            ps.setDouble(2, pro.getPrice());
	            ps.setDouble(3, pro.getWholesalePrice());
	            ps.setString(4, pro.getProductType());
	            ps.setString(5, pro.getProductWeight());
	            ps.setString(6, pro.getProductHeight());
	            ps.setInt(7, pro.getQuantity());
	            ps.setString(8, pro.getDescription());
	            ps.setInt(9, productId);

	            rowsUpdated = ps.executeUpdate();
	        } finally {
	            if (ps != null) {
	                ps.close();
	            }
	        }

	        return rowsUpdated;
	    }


 
	    public  int deleteProduct(int productId)throws Exception{
	        String query="delete from products where product_id="+productId;
	         System.out.println(query);
	         Statement st=null;
	         try{
	             st=con.createStatement();
	             int rows=st.executeUpdate(query);
	             return rows;
	             
	        }finally{
	             if(st!=null){
	                 st.close();
	             }
	        }
	    }//end DeleteFaculty
	    

}
