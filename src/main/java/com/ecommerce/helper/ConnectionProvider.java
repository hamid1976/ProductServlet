package com.ecommerce.helper;
import java.sql.*;
import java.util.Vector;


public class ConnectionProvider {
	
    private static Connection con;
    
    public static Connection getConnection(){
        if(con==null){
            try{
                //load Driver
                Class.forName("com.mysql.jdbc.Driver");
                
                //create connetion
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop","root","HAMID1976");
            }catch(Exception e){
                e.printStackTrace();
            }
        }//if con==null
        return con;
    }
    public static void main(String arg[]){
    
    getConnection();
    System.out.println(con);
    }
}