/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.IncomeBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class IncomeDAO {

    static Connection con;

    public int AddIncome(IncomeBean ib) {
        con = (Connection) ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into incomes(inc_id,inc_ac,userid,inc_catid,amount,transaction_date,receivby,remark)values('" + ib.getInc_id() + "','" + ib.getInc_ac() + "','" + ib.getUserid() + "','" + ib.getInc_catid() + "','" + ib.getAmount() + "','" + ib.getTransaction_date() + "','" + ib.getReceivby() + "','" + ib.getRemark() + "')";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    //delete
    public int DeleteIncome(int inc_id) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from incomes where inc_id='" + inc_id + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int UpdateIncome(IncomeBean ib) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update incomes set inc_ac='" + ib.getInc_ac() + "',userid='" + ib.getUserid() + "',inc_catid='" + ib.getInc_catid() + "',amount='" + ib.getAmount() + "',receivby='" + ib.getReceivby() + "',remark='" + ib.getRemark() + "'where SID='"+ib.getInc_id()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    public IncomeBean findByinc_id(int inc_id) {
        con = ConnectionPool.connectDB();
        String sql = "select * from incomes where inc_id='" + inc_id + "'";
        IncomeBean ibean = new IncomeBean();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of All Income : ");
            while (rs.next()) {
                ibean.setInc_id(rs.getInt("Inc_id"));
                ibean.setInc_ac(rs.getString("Inc_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setInc_catid(rs.getInt("Inc_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setReceivby(rs.getString("Receivby"));
                ibean.setRemark(rs.getString("Remark"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }
    public ArrayList<IncomeBean>findAllData(){
        con=ConnectionPool.connectDB();
        ArrayList<IncomeBean> Ib = new ArrayList<>();
        String sql = "select * from incomes";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Income: ");
      
            while(rs.next()){
                IncomeBean ibean = new IncomeBean();
                ibean.setInc_id(rs.getInt("Inc_id"));
                ibean.setInc_ac(rs.getString("Inc_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setInc_catid(rs.getInt("Inc_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setReceivby(rs.getString("Receivby"));
                ibean.setRemark(rs.getString("Remark"));
                
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }

     public ArrayList<IncomeBean>findAll(int userid){
        con=ConnectionPool.connectDB();
        ArrayList<IncomeBean> Ib = new ArrayList<>();
        String sql = "select * from incomes where userid='"+userid+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Income: ");
      
            while(rs.next()){
                IncomeBean ibean = new IncomeBean();
                ibean.setInc_id(rs.getInt("Inc_id"));
                ibean.setInc_ac(rs.getString("Inc_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setInc_catid(rs.getInt("Inc_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setReceivby(rs.getString("Receivby"));
                ibean.setRemark(rs.getString("Remark"));
                
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
     
      public ArrayList<IncomeBean>findAlldatewise(String sdate,String edate,int userid){
        con=ConnectionPool.connectDB();
        ArrayList<IncomeBean> Ib = new ArrayList<>();
        String sql = "select * from incomes where '"+sdate+"' and '"+edate+"' and userid='"+userid+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Income: ");
      
            while(rs.next()){
                IncomeBean ibean = new IncomeBean();
                ibean.setInc_id(rs.getInt("Inc_id"));
                ibean.setInc_ac(rs.getString("Inc_ac"));
                ibean.setUserid(rs.getInt("Userid"));
                ibean.setInc_catid(rs.getInt("Inc_catid"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setReceivby(rs.getString("Receivby"));
                ibean.setRemark(rs.getString("Remark"));
                
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    public static void main(String[] args) {
        IncomeBean ib = new IncomeBean();
        IncomeDAO id = new IncomeDAO();
        ib.setInc_id(11);
        ib.setInc_ac("1234563");
        ib.setUserid(1);
        ib.setInc_catid(2);
        ib.setAmount(24800);
        ib.setTransaction_date("03/01/23");
        ib.setReceivby("rehan");
        ib.setRemark("success");
        // ADD INCOME
        //        int A = id.AddIncome(ib);
        //        if (A>0){
        //            System.out.println("Data entry successfully");
        //        }else{
        //            System.out.println("Data entry fail");
        //        }

//        DELETE
//        int A = id.DeleteIncome(11);
//        if (A > 0) {
//            System.out.println("Data deleted");
//        } else {
//            System.out.println("Data not deleted");
//        }
        //UPDATE
//        int A = id.UpdateIncome(ib);
//        if (A>0){
//            System.out.println("Data updated successfully");
//            
//        }else{
//            System.out.println("Data not updated ");
//        }

//        Find By ID
//        IncomeBean ibean = id.findByinc_id(10);
//        System.out.println("Inc_id : " + ibean.getInc_id() + "Inc_ac : " + ibean.getInc_ac() + "userid: " + ibean.getUserid() + "inc_catid : " + ibean.getInc_catid()+ "amount : "+ibean.getAmount() + "Transaction_date : " + ibean.getTransaction_date() + "Receive_By : " + ibean.getReceivby() + "Remark: " + ibean.getRemark());

        //Find by All
//      ArrayList<IncomeBean>AllData=  id.findAllData();
//      for(IncomeBean x:AllData){
//       System.out.println("Inc_id  : "+x.getInc_id()+"   Inc_ac: "+x.getInc_ac()+"  userid : "+x.getUserid()+"  Inc_catid: "+x.getInc_catid()+"   amount : "+x.getAmount()+"Transaction_date: "+x.getTransaction_date()+"Receive_by: "+x.getReceivby()+ "Remark: "+x.getRemark());
//   }
//      ArrayList<IncomeBean>AllData=  id.findAll(1);
//      for(IncomeBean x:AllData){
//       System.out.println("Inc_id  : "+x.getInc_id()+"   Inc_ac: "+x.getInc_ac()+"  userid : "+x.getUserid()+"  Inc_catid: "+x.getInc_catid()+"   amount : "+x.getAmount()+"Transaction_date: "+x.getTransaction_date()+"Receive_by: "+x.getReceivby()+ "Remark: "+x.getRemark());
//   }

     ArrayList<IncomeBean>AllData=  id.findAlldatewise("03/01/23","04/01/23",1);
      for(IncomeBean x:AllData){
       System.out.println("Inc_id  : "+x.getInc_id()+"   Inc_ac: "+x.getInc_ac()+"  userid : "+x.getUserid()+"  Inc_catid: "+x.getInc_catid()+"   amount : "+x.getAmount()+"Transaction_date: "+x.getTransaction_date()+"Receive_by: "+x.getReceivby()+ "Remark: "+x.getRemark());
   }
    }
}
