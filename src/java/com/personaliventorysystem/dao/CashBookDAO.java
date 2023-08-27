/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.CashBookBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class CashBookDAO {
    static Connection con;

    public int AddCashBook(CashBookBean cb) {
        con = (Connection) ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into cash_book(acid,account,transaction_date,amount,userid,operation)values('" + cb.getAcid() + "','" + cb.getAccount() + "','" + cb.getTransaction_date() + "','" + cb.getAmount() + "','" + cb.getUserid() + "','" + cb.getUserid() + "')";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CashBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    //delete
    public int DeleteCashBook(int acid) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from cash_book where acid='" + acid + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CashBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int UpdateCashbook(CashBookBean cb) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update cash_book set account='" + cb.getAccount() + "',transaction_date='" + cb.getTransaction_date() + "',amount='" + cb.getAmount() + "',userid='" + cb.getUserid() + "',operation='" + cb.getOperation() + "' where Acid='"+cb.getAcid()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CashBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public CashBookBean findBy_acid(int acid) {
        con = ConnectionPool.connectDB();
        String sql = "select * from cash_book where acid='" + acid + "'";
        CashBookBean ibean = new CashBookBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Students : ");
            while (rs.next()) {
                ibean.setAcid(rs.getInt("Acid"));
                ibean.setAccount(rs.getString("Account"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setUserid(rs.getInt("userid"));
                ibean.setOperation(rs.getString("Operation"));

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }

    public ArrayList<CashBookBean> findAllData() {
        con = ConnectionPool.connectDB();
        ArrayList<CashBookBean> Ib = new ArrayList<>();
        String sql = "select * from cash_book";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Students: ");

            while (rs.next()) {
                CashBookBean ibean = new CashBookBean();
                ibean.setAcid(rs.getInt("Acid"));
                ibean.setAccount(rs.getString("Account"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setUserid(rs.getInt("userid"));
                ibean.setOperation(rs.getString("Operation"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
 public ArrayList<CashBookBean> findAlldatewise(String sdate,String edate,int userid) {
        con = ConnectionPool.connectDB();
        ArrayList<CashBookBean> Ib = new ArrayList<>();
        String sql = "select * from cash_book where '"+sdate+"' and '"+edate+"' and userid='"+userid+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Students: ");

            while (rs.next()) {
                CashBookBean ibean = new CashBookBean();
                ibean.setAcid(rs.getInt("Acid"));
                ibean.setAccount(rs.getString("Account"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setUserid(rs.getInt("userid"));
                ibean.setOperation(rs.getString("Operation"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    public static void main(String[] args) {
        CashBookBean cb = new CashBookBean();
        CashBookDAO cd = new CashBookDAO();
        cb.setAcid(1);
        cb.setAccount("73608");
        cb.setTransaction_date("03-04-23");
        cb.setAmount(103989);
        cb.setUserid(1);
        cb.setOperation("receive");

//        ADD
//                int A = cd.AddCashBook(cb);
//                if (A>0){
//                    System.out.println("Data entry successfully");
//                }else{
//                    System.out.println("Data entry fail");
//                }
//       DELETE
//        int A = cd.DeleteCashBook(1);
//        if (A > 0) {
//            System.out.println("Data deleted");
//        } else {
//            System.out.println("Data not deleted");
//        }

//      UPDATE
//        int A = cd.UpdateCashbook(cb);
//        if (A>0){
//            System.out.println("Data updated successfully");
//            
//        }else{
//            System.out.println("Data not updated ");
//        }

//        Find By ID
//        CashBookBean ibean = cd.findBy_acid(2);
//        System.out.println("acid : " + ibean.getAcid() + "account : " + ibean.getAccount() + "transaction_date: " + ibean.getTransaction_date()+ "amount : "+ibean.getAmount() + "userid : " + ibean.getUserid() + "operation : " + ibean.getOperation());

//      Find All
    
    ArrayList<CashBookBean>AllData=cd.findAllData();
        for(CashBookBean x:AllData){
            System.out.println("Acid : " + x.getAcid() + "  account : " + x.getAccount() + " transaction_date: " + x.getTransaction_date()+ " amount : "+x.getAmount() + " userid : " + x.getUserid() + " operation : " + x.getOperation());
    }

//     ArrayList<CashBookBean>Alldatewise = cd.findAlldatewise("2/06/23","3/06/23",1);
//         for(CashBookBean x:Alldatewise){
//           System.out.println("Acid : " + x.getAcid() + "  account : " + x.getAccount() + "   transaction_date: " + x.getTransaction_date()+ "   amount : "+x.getAmount() + "   userid : " + x.getUserid() + "   operation : " + x.getOperation());
//   }
    }

}
