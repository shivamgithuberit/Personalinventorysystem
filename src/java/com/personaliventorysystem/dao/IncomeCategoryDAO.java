/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.IncomeCategoryBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class IncomeCategoryDAO {

    static Connection con;

    public int AddData(IncomeCategoryBean inb) {
        con = (Connection) ConnectionPool.connectDB();
        int re = 0;
        String sql = "insert into income_category(inc_catname,inc_catdetails,userid)values('" + inb.getInc_catname() + "','" + inb.getInc_catdetails()+ "','" + inb.getUserid() + "')";
         Statement stmt;
        try {
            stmt = con.createStatement();
            re = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }
   
    //delete
    public int DeleteIncomeCategory(int inc_catid) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from income_category where inc_catid='" + inc_catid + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
     public int UpdateIncomeCategory(IncomeCategoryBean inb) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update income_category set inc_catname='" + inb.getInc_catname() + "',inc_catdetails='" + inb.getInc_catdetails() + "',userid='" + inb.getUserid() + "'where inc_catid='"+inb.getInc_catid()+'"';
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }
     
    public IncomeCategoryBean findByinc_catid(int userid) {
        con = ConnectionPool.connectDB();
        String sql = "select * from income_category where inc_catid='" + userid + "'";
        IncomeCategoryBean ibean = new IncomeCategoryBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Income : ");
            while (rs.next()) {
               ibean.setInc_catid(rs.getInt("inc_catid"));
               ibean.setInc_catname(rs.getString("Inc_catname"));
               ibean.setInc_catdetails(rs.getString("Inc_catdetails"));
               ibean.setUserid(rs.getInt("Userid"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }
    
     public ArrayList<IncomeCategoryBean>findAllData(){
        con=ConnectionPool.connectDB();
        ArrayList<IncomeCategoryBean> Ib = new ArrayList<>();
        String sql = "select * from income_category";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Income: ");
      
            while(rs.next()){
                IncomeCategoryBean ibean = new IncomeCategoryBean();
                ibean.setInc_catid(rs.getInt("inc_catid"));
                ibean.setInc_catname(rs.getString("Inc_catname"));
                ibean.setInc_catdetails(rs.getString("Inc_catdetails"));
                ibean.setUserid(rs.getInt("Userid"));
                
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }

        public int FindIncid( String catname, int userid){
        int r=0;
        try {
            con = ConnectionPool.connectDB();
            ArrayList<IncomeCategoryBean> Ib = new ArrayList<>();
            String sql = "select inc_catid from income_category where userid ='"+userid+"' AND inc_catname='"+catname+"'";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
             while(rs.next()){
                 r=rs.getInt("inc_catid");
             }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
          public ArrayList<IncomeCategoryBean>findAll(int userid){
        con=ConnectionPool.connectDB();
        ArrayList<IncomeCategoryBean> Ib = new ArrayList<>();
        String sql = "select * from income_category where userid='"+userid+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Income: ");
      
            while(rs.next()){
                IncomeCategoryBean ibean = new IncomeCategoryBean();
                ibean.setInc_catid(rs.getInt("inc_catid"));
                ibean.setInc_catname(rs.getString("Inc_catname"));
                ibean.setInc_catdetails(rs.getString("Inc_catdetails"));
                ibean.setUserid(rs.getInt("Userid"));
                
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }

    
    public static void main(String[] args) {
        IncomeCategoryBean inb =new IncomeCategoryBean();
        IncomeCategoryDAO ind = new IncomeCategoryDAO();
        inb.setInc_catid(2);
        inb.setInc_catname("namza");
        inb.setInc_catdetails("online");
        inb.setUserid(2);
        
        //ADD
//        int A=ind.AddData(inb);
//        if (A>0){
//            System.out.println("Data added successfully");
//        }else
//            System.out.println("Data not added");
//    }
   
    //DELETE
//    int A = ind.DeleteIncomeCategory(1);
//    if(A>0){
//        System.out.println("Data deleted");
//    }else{
//        System.out.println("Data not deleted");
//    }
//    UPDATE
//            int A = ind.UpdateIncomeCategory(inb);
//        if (A>0){
//            System.out.println("Data updated successfully");
//            
//        }else{
//            System.out.println("Data not updated ");
//        }
    
//    IncomeCategoryBean ibean = ind.findByinc_catid(2);
//        System.out.println("Inc_catid: "+ibean.getInc_catid()+"Inc_catnamne: "+ibean.getInc_catname()+"Inc_catdetails: "+ibean.getInc_catdetails()+"Userid : "+ibean.getUserid());

//    ArrayList<IncomeCategoryBean>AllData=ind.findAllData();
//        for(IncomeCategoryBean x:AllData){
//           System.out.println("Inc_catid: "+x.getInc_catid()+"Inc_catnamne: "+x.getInc_catname()+"Inc_catdetails: "+x.getInc_catdetails()+"Userid : "+x.getUserid());
//
//        }
     ArrayList<IncomeCategoryBean>AllData=ind.findAll(2);
        for(IncomeCategoryBean x:AllData){
           System.out.println("Inc_catid: "+x.getInc_catid()+"  Inc_catnamne: "+x.getInc_catname()+"  Inc_catdetails: "+x.getInc_catdetails() +"  Userid : "+x.getUserid());

        }
    }
    
}

