/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.ExpensesBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ExpensesDAO {

    static Connection con;

    public int AddExpenses(ExpensesBean eb) {
        con = (Connection) ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into expenses(exp_id,exp_ac,userid,exp_catid,amount,transaction_date,payby,remark)values('" + eb.getExp_id() + "','" + eb.getExp_ac() + "','" + eb.getUserid() + "','" + eb.getExp_catid() + "','" + eb.getAmount() + "','" + eb.getTransaction_date() + "','" + eb.getPayby() + "','" + eb.getRemark() + "')";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int DeleteExpenses(int exp_id) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from expenses where exp_id='" + exp_id + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int UpdateExpenses(ExpensesBean eb) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update expenses set exp_ac='" + eb.getExp_ac() + "',userid='" + eb.getUserid() + "',exp_catid='" + eb.getExp_catid() + "',amount='" + eb.getAmount() + "',payby='" + eb.getPayby() + "',remark='" + eb.getRemark() + "'where exp_id ='"+eb.getExp_id()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public ExpensesBean findByexp_id(int exp_id) {
        con = ConnectionPool.connectDB();
        String sql = "select * from expenses where exp_id='" + exp_id + "'";
        ExpensesBean ibean = new ExpensesBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Expenses : ");
            while (rs.next()) {
                ibean.setExp_id(rs.getInt("Exp_id"));
                ibean.setExp_ac(rs.getString("Exp_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setPayby(rs.getString("Payby"));
                ibean.setRemark(rs.getString("Remark"));

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }

    public ArrayList<ExpensesBean> findAllData() {
        con = ConnectionPool.connectDB();
        ArrayList<ExpensesBean> Ib = new ArrayList<>();
        String sql = "select * from expenses";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Expenses: ");

            while (rs.next()) {
                ExpensesBean ibean = new ExpensesBean();
                ibean.setExp_id(rs.getInt("Exp_id"));
                ibean.setExp_ac(rs.getString("Exp_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setPayby(rs.getString("Payby"));
                ibean.setRemark(rs.getString("Remark"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    
    public ArrayList<ExpensesBean> findAll(int userid) {
        con = ConnectionPool.connectDB();
        ArrayList<ExpensesBean> Ib = new ArrayList<>();
        String sql = "select * from expenses where userid='"+userid+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Expenses: ");

            while (rs.next()) {
                ExpensesBean ibean = new ExpensesBean();
                ibean.setExp_id(rs.getInt("Exp_id"));
                ibean.setExp_ac(rs.getString("Exp_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setPayby(rs.getString("Payby"));
                ibean.setRemark(rs.getString("Remark"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
     
    public ArrayList<ExpensesBean> findAllDatewise(String sdate,String edate,int userid) {
        con = ConnectionPool.connectDB();
        ArrayList<ExpensesBean> Ib = new ArrayList<>();
        String sql = "select * from expenses where '"+sdate+"' and '"+edate+"' and userid='"+userid+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Expenses: ");

            while (rs.next()) {
                ExpensesBean ibean = new ExpensesBean();
                ibean.setExp_id(rs.getInt("Exp_id"));
                ibean.setExp_ac(rs.getString("Exp_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setExp_catid(rs.getInt("Exp_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setPayby(rs.getString("Payby"));
                ibean.setRemark(rs.getString("Remark"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpensesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }

    public static void main(String[] args) {
        ExpensesBean eb = new ExpensesBean();
        ExpensesDAO ed = new ExpensesDAO();
        eb.setExp_id(2);
        eb.setExp_ac("12378");
        eb.setUserid(11);
        eb.setExp_catid(2);
        eb.setAmount(4069);
        eb.setTransaction_date("03/03/23");
        eb.setPayby("tom");
        eb.setRemark("success");

//        int A = ed.AddExpenses(eb);
//        if(A>0){
//            System.out.println("Data Added successfully ");
//        }else{
//            System.out.println("Data not Added");
//        }
//        int A = ed.DeleteExpenses(2);
//        if (A>0){
//            System.out.println("Data Deleted");
//        }else{
//            System.out.println("Data not deleted");
//        }
//          int A = ed.UpdateExpenses(eb);
//          if (A>0){
//              System.out.println("Data Updated successfully");
//          }else{
//              System.out.println("Data not Updated");
//          }
//    Find By ID
//        ExpensesBean ibean = ed.findByexp_id(1);
//        System.out.println("Exp_id : " + ibean.getExp_id() + "Exp_ac : " + ibean.getExp_ac() + "userid: " + ibean.getUserid() + "exp_catid : " + ibean.getExp_catid() + "amount : " + ibean.getAmount() + "Transaction_date : " + ibean.getTransaction_date() + "Payby : " + ibean.getPayby() + "Remark: " + ibean.getRemark());

//ArrayList<ExpensesBean> AllData=ed.findAllData();
//    for(ExpensesBean x:AllData){
//        System.out.println("Exp_id : " + x.getExp_id() + "Exp_ac : " + x.getExp_ac() + "userid: " + x.getUserid() + "exp_catid : " +x.getExp_catid() + "amount : " + x.getAmount() + "Transaction_date : " + x.getTransaction_date() + "Payby : " + x.getPayby() + "Remark: " +x.getRemark());
//
////    }
//  ArrayList<ExpensesBean> AllData=ed.findAll(11);
//    for(ExpensesBean x:AllData){
//        System.out.println(" Exp_id : " + x.getExp_id() + "  Exp_ac : " + x.getExp_ac() + " userid: " + x.getUserid() + " exp_catid : " +x.getExp_catid() + "  amount : " + x.getAmount() + "  Transaction_date : " + x.getTransaction_date() + " Payby : " + x.getPayby() + "Remark: " +x.getRemark());
//
//    }
 ArrayList<ExpensesBean> AllData=ed.findAllDatewise("03/03/23","04/03/23",11);
    for(ExpensesBean x:AllData){
        System.out.println(" Exp_id : " + x.getExp_id() + "  Exp_ac : " + x.getExp_ac() + " userid: " + x.getUserid() + " exp_catid : " +x.getExp_catid() + "  amount : " + x.getAmount() + "  Transaction_date : " + x.getTransaction_date() + " Payby : " + x.getPayby() + "  Remark: " +x.getRemark());

    }
    }
}
