/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.personaliventorysystem.utility;

import java.sql.*;

/**
 *
 * @author HP
 */
public class ConnectionPool {
    static Connection conn;
    public static Connection  connectDB(){
        try {
            //step 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/personalinventorysystem","root","Jyoti@91");
            System.out.println("Connection Success");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection Fail Driver not found");
            System.out.println(""+ex); 
        }catch(SQLException ex){
            System.out.println(""+ex);
            System.out.println("SQL url error");
        }
        return conn;
    }
    public static void main(String[] args) {
        ConnectionPool.connectDB();
       
        
    }
}
