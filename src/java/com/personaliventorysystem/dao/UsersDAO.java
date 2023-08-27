/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.UsersBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UsersDAO {

    static Connection con;

    public int AddUsers(UsersBean ub) {
        con = (Connection) ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into users(userid,username,password,name,address,mobile,email)values('" + ub.getUserid() + "','" + ub.getUsername() + "','" + ub.getPassword() + "','" + ub.getName() + "','" + ub.getAddress() + "','" + ub.getMobile() + "','" + ub.getEmail() + "')";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     //delete
    public int DeleteUsers(int userid) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from users where userid='" + userid + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     
     public ArrayList<UsersBean>findAllData(){
        con=ConnectionPool.connectDB();
        ArrayList<UsersBean> ub = new ArrayList<>();
        String sql = "select * from users";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Users: ");
      
            while(rs.next()){
                UsersBean ibean = new UsersBean();
               ibean.setUserid(rs.getInt("userid"));
               ibean.setUsername(rs.getString("username"));
               ibean.setPassword(rs.getString("password"));
               ibean.setName(rs.getString("name"));
               ibean.setAddress(rs.getString("address"));
               ibean.setMobile(rs.getString("mobile"));
               ibean.setEmail(rs.getString("email"));
                
               ub.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ub;
    }
     public int UpdateUsers(UsersBean ub) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update users set username='" + ub.getUsername() + "',password='" + ub.getPassword() + "',name='" + ub.getName() + "',address='" + ub.getAddress() + "',mobile='" + ub.getMobile() + "',email='" + ub.getEmail() +"' where userid='"+ub.getUserid()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }
      public int checkAvailability(String username) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "select userid from users where username='" + username + "'";
       
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                r=rs.getInt("userid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }
     

      public UsersBean Authenticate(String username,String password){
    Connection con=ConnectionPool.connectDB();
    String sql="select userid from users where username='"+username+"' and password='"+password+"'";
    UsersBean bean=new UsersBean();
      try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Users: ");
      
            while(rs.next()){
                UsersBean ibean = new UsersBean();
               ibean.setUserid(rs.getInt("userid"));
               ibean.setUsername(rs.getString("username"));
               ibean.setPassword(rs.getString("password"));
               ibean.setName(rs.getString("name"));
               ibean.setAddress(rs.getString("address"));
               ibean.setMobile(rs.getString("mobile"));
               ibean.setEmail(rs.getString("email"));
            } 
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bean;
    }
    

    
     public int loginCheck(String username,String password){
        Connection con=ConnectionPool.connectDB();
        String sql="select userid from users where username='"+username+"' and password='"+password+"'";
        int r=0;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                r=rs.getInt("userid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     
    public UsersBean findByuserid(int userid) {
        con = ConnectionPool.connectDB();
        String sql = "select * from users where userid='" + userid + "'";
        UsersBean ibean = new UsersBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Users : ");
            while (rs.next()) {
               ibean.setUserid(rs.getInt("userid"));
               ibean.setUsername(rs.getString("username"));
               ibean.setPassword(rs.getString("password"));
               ibean.setName(rs.getString("name"));
               ibean.setAddress(rs.getString("address"));
               ibean.setMobile(rs.getString("mobile"));
               ibean.setEmail(rs.getString("email"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }
     
    
    public static void main(String[] args) {
        UsersBean ub = new UsersBean();
        UsersDAO ud = new UsersDAO();
        ub.setUserid(13);
        ub.setUsername("ram123");
        ub.setPassword("1234");
        ub.setName("Ram");
        ub.setAddress("Plot no. 02/1");
        ub.setMobile("898788742");
        ub.setEmail("ram@123");
        
        // ADD INCOME
//        int A = ud.AddUsers(ub);
//        if (A > 0) {
//            System.out.println("Data entry successfully");
//        } else {
//            System.out.println("Data entry fail");
//        }

    //User Availability
//      int A = ud.checkAvailability("xyz");
//        if (A > 0) {
//            System.out.println("User Available");
//        } else {
//            System.out.println("User Not  Available");
//        }

//    User and Password Availability

//        int A = ud.checkAvailability("xyz","114");
//        if (A > 0) {
//            System.out.println("User Available..");
//        } else {
//            System.out.println("User Not  Available..");
//        }
    
//   DELETE

//        int A = ud.DeleteUsers(1);
//        if (A > 0) {
//            System.out.println("Data deleted");
//        } else {
//            System.out.println("Data not deleted");
//        }
//    }

//    UPDATE

//        int A = ud.UpdateUsers(ub);
//        if (A>0){
//            System.out.println("Data updated successfully");
//            
//        }else{
//            System.out.println("Data not updated ");
//        }

// Find By ID
//      `
//Find by All
//      ArrayList<UsersBean>AllData=  ud.findAllData();
//      for(UsersBean x:AllData){
//       System.out.println("userid : " + x.getUserid() + "  username : " + x.getUsername() + "  password: " +x.getPassword() + "  name: " + x.getName()+ "  address : "+x.getAddress() + "  mobile : " + x.getMobile() + "   Email : " + x.getEmail());
//   }

//     UsersBean ibean = ud.checkAvailability("xyz");
//        System.out.println("userid : " + ibean.getUserid() + "  username : " + ibean.getUsername() + "  password: " + ibean.getPassword() + "  name: " + ibean.getName()+ "  address : "+ibean.getAddress() + "  mobile : " + ibean.getMobile() + "   Email : " + ibean.getEmail());


//     UsersBean ibean = ud.Authenticate("ram123","1234");
//     System.out.println("userid : " + ibean.getUserid() + "  username : " + ibean.getUsername() + "  password: " + ibean.getPassword() + "  name: " + ibean.getName()+ "  address : "+ibean.getAddress() + "  mobile : " + ibean.getMobile() + "   Email : " + ibean.getEmail());

//  int x=ud.loginCheck("ram123", "1234");
//        if(x>0){
//            System.out.println("Login Success : Uid : "+x);
//        }
//        else{
//            System.out.println("Login Fail "+x);
//        }

}
}


