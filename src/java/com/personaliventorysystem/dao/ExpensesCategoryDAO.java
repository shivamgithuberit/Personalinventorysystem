/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.ExpensesCategoryBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ExpensesCategoryDAO {

    static Connection con;

    public int AddData(ExpensesCategoryBean enb) {
        con = (Connection) ConnectionPool.connectDB();
        int re = 0;
        String sql = "insert into expenses_category(exp_catname,exp_catdetails,userid)values('" + enb.getExp_catname() + "','" + enb.getExp_catdetails() + "','" + enb.getUserid() + "')";
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
    public int DeleteExpensesCategory(int exp_catid) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from expenses_category where exp_catid='" + exp_catid + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int UpdateExpensesCategory(ExpensesCategoryBean enb) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "update expenses_category set exp_catname='" + enb.getExp_catname() + "', exp_catdetails='" + enb.getExp_catdetails() + "' where exp_catid='" + enb.getExp_catid()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public ExpensesCategoryBean findByexp_catid(int userid) {
        con = ConnectionPool.connectDB();
        String sql = "select * from expenses_category where exp_catid='" + userid + "'";
        ExpensesCategoryBean ibean = new ExpensesCategoryBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Expenses : ");
            while (rs.next()) {
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setExp_catname(rs.getString("Exp_catname"));
                ibean.setExp_catdetails(rs.getString("Exp_catdetails"));
                ibean.setUserid(rs.getInt("Userid"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }

    public ArrayList<ExpensesCategoryBean> findAllData() {
        con = ConnectionPool.connectDB();
        ArrayList<ExpensesCategoryBean> Ib = new ArrayList<>();
        String sql = "select * from expenses_category";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Expenses: ");

            while (rs.next()) {
                ExpensesCategoryBean ibean = new ExpensesCategoryBean();
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setExp_catname(rs.getString("Exp_catname"));
                ibean.setExp_catdetails(rs.getString("Exp_catdetails"));
                ibean.setUserid(rs.getInt("Userid"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    public int FindIncid( String catname, int userid){
        int r=0;
        try {
            con = ConnectionPool.connectDB();
            ArrayList<ExpensesCategoryBean> Ib = new ArrayList<>();
            String sql = "select exp_catid from expenses_category where userid ='"+userid+"' AND exp_catname='"+catname+"'";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
             while(rs.next()){
                 r=rs.getInt("exp_catid");
             }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

        public ArrayList<ExpensesCategoryBean> findAll(int userid) {
        con = ConnectionPool.connectDB();
        ArrayList<ExpensesCategoryBean> Ib = new ArrayList<>();
        String sql = "select * from expenses_category where userid ='"+userid+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Expenses: ");

            while (rs.next()) {
                ExpensesCategoryBean ibean = new ExpensesCategoryBean();
                ibean.setExp_catid(rs.getInt("exp_catid"));
                ibean.setExp_catname(rs.getString("exp_catname"));
                ibean.setExp_catdetails(rs.getString("exp_catdetails"));
                ibean.setUserid(rs.getInt("userid"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    public static void main(String[] args) {
        ExpensesCategoryBean enb = new ExpensesCategoryBean();
        ExpensesCategoryDAO end = new ExpensesCategoryDAO();
        enb.setExp_catid(1);
        enb.setExp_catname("suhaan");
        enb.setExp_catdetails("online");
        enb.setUserid(6);

        //ADD
//        int A = end.AddData(enb);
//        if (A > 0) {
//            System.out.println("Data added successfully");
//        } else {
//            System.out.println("Data not added");
//        }
        //DELETE
//    int A = end.DeleteExpensesCategory(3);
//    if(A>0){
//        System.out.println("Data deleted");
//    }else{
//        System.out.println("Data not deleted");
//    }
//    
   // UPDATE
        int A = end.UpdateExpensesCategory(enb);
        if (A>0){
            System.out.println("Data updated successfully");
            
        }else{
            System.out.println("Data not updated ");
        }

//find by id

//       ExpensesCategoryBean ibean = end.findByexp_catid(1);
//       System.out.println("Exp_catid: "+ibean.getExp_catid()+"Exp_catnamne: "+ibean.getExp_catname()+"Exp_catdetails: "+ibean.getExp_catdetails()+"Userid: "+ibean.getUserid());

//ArrayList<ExpensesCategoryBean> AllData=end.findAllData();
//    for(ExpensesCategoryBean x:AllData){
//             System.out.println("Exp_catid: "+x.getExp_catid()+"Exp_catnamne: "+x.getExp_catname()+"Exp_catdetails: "+x.getExp_catdetails()+"Userid: "+x.getUserid());
//  
//    
ArrayList<ExpensesCategoryBean> AllData=end.findAll(6);
    for(ExpensesCategoryBean x:AllData){
             System.out.println("Exp_catid: "+x.getExp_catid()+"  Exp_catnamne: "+x.getExp_catname()+" Exp_catdetails: "+x.getExp_catdetails()+" Userid: "+x.getUserid());
  
    }
    }
}

