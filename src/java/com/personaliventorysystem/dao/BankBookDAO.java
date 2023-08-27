 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.BankBookBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class BankBookDAO {

    static Connection con;

    public int AddBankBook(BankBookBean bb) {
        con = (Connection) ConnectionPool.connectDB();
        int r = 0;
        String sql = "insert into bank_book(acid,account,transaction_date,amount,userid,operation)values('" + bb.getAcid() + "','" + bb.getAccount() + "','" + bb.getTransaction_date() + "','" + bb.getAmount() + "','" + bb.getUserid() + "','" + bb.getOperation() + "')";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    //delete
    public int DeleteBankBook(int acid) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "delete from bank_book where acid='" + acid + "'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int UpdateBankbook(BankBookBean bb) {
        con = ConnectionPool.connectDB();
        int r = 0;
        String sql = "Update bank_book set account='" + bb.getAccount() + "',transaction_date='" + bb.getTransaction_date() + "',amount='" + bb.getAmount() + "',userid='" + bb.getUserid() + "',operation='" + bb.getOperation() + "' where Acid='"+bb.getAcid()+"'";
        Statement stmt;
        try {
            stmt = con.createStatement();
            r = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }
  

    public BankBookBean findBy_acid(int acid) {
        con = ConnectionPool.connectDB();
        String sql = "select * from bank_book where acid='" + acid + "'";
        BankBookBean ibean = new BankBookBean();
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
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ibean;
    }
    
     public ArrayList<BankBookBean> findAllData() {
        con = ConnectionPool.connectDB();
        ArrayList<BankBookBean> Ib = new ArrayList<>();
        String sql = "select * from bank_book";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Students: ");

            while (rs.next()) {
                BankBookBean ibean = new BankBookBean();
                ibean.setAcid(rs.getInt("Acid"));
                ibean.setAccount(rs.getString("Account"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setUserid(rs.getInt("userid"));
                ibean.setOperation(rs.getString("Operation"));

                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }

    public ArrayList<BankBookBean> findAllDatewise(String sdate,String edate,int userid) {
        con = ConnectionPool.connectDB();
        ArrayList<BankBookBean> Ib = new ArrayList<>();
        String sql = "select * from bank_book where '"+sdate+"' and '"+edate+"' and userid='"+userid+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Data of all Students: ");

            while (rs.next()) {
                BankBookBean ibean = new BankBookBean();
                ibean.setAcid(rs.getInt("Acid"));
                ibean.setAccount(rs.getString("Account"));
                ibean.setTransaction_date(rs.getString("Transaction_date"));
                ibean.setAmount(rs.getDouble("Amount"));
                ibean.setUserid(rs.getInt("userid"));
                ibean.setOperation(rs.getString("Operation"));
                Ib.add(ibean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ib;
    }
    public double ClosingBalance(int userid){
         con = ConnectionPool.connectDB();
         double l=0,z=0,y=0;
         String sql="select sum(amount) as total_receive from bank_book where operation='receive' and userid='"+userid+"'";
         String sqlone="select sum(amount) as total_pay from bank_book where operation='pay' and userid='"+userid+"'";
        try {
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                y=rs.getFloat("total_receive");
                System.out.println("Total receive : "+y);
            }
           ResultSet ro = stmt.executeQuery(sqlone);
           if(ro.next()){
               z=ro.getFloat("total_pay");
               System.out.println("Total Pay : "+z);
           }
           l=y-z;
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BankBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;  
    }

    public static void main(String[] args) {
        BankBookBean bb = new BankBookBean();
        BankBookDAO bd = new BankBookDAO();
        bb.setAcid(4);
        bb.setAccount("41278");
        bb.setTransaction_date("02/06/22");
        bb.setAmount(61254);
        bb.setUserid(3);
        bb.setOperation("nu");

//         ADD
//                int A = bd.AddBankBook(bb);
//                if (A>0){
//                    System.out.println("Data entry successfully");
//                }else{
//                    System.out.println("Data entry fail");
//                }

//      DELETE
//        int A = bd.DeleteBankBook(2);
//        if (A > 0) {
//            System.out.println("Data deleted");
//        } else {
//            System.out.println("Data not deleted");
//        }

        //UPDATE
//        int A = bd.UpdateBankbook(bb);
//        if (A>0){
//            System.out.println("Data updated successfully");
//            
//        }else{
//            System.out.println("Data not updated ");
//        }

//Find By ID
//        BankBookBean ibean = bd.findBy_acid(3);
//        System.out.println("acid : " + ibean.getAcid() + "account : " + ibean.getAccount()+ "transaction_date: " + ibean.getTransaction_date()+ "amount : "+ibean.getAmount() + "userid : " + ibean.getUserid() + "operation : " + ibean.getOperation());

//Find All

// ArrayList<BankBookBean>AllData=  bd.findAllData();
//      for(BankBookBean x:AllData){
//       System.out.println("Acid : "+x.getAcid()+"   Account: "+x.getAccount()+ "  Transaction_date: "+x.getTransaction_date()+"   amount : "+x.getAmount()+"  userid : "+x.getUserid()+ "  Operation: "+x.getOperation());
//   }
// 

// ArrayList<BankBookBean>Alldatewise=  bd.findAllDatewise("2/06/23","3/06/23",3);
//      for(BankBookBean x:Alldatewise){
//       System.out.println("Acid : "+x.getAcid()+"   Account: "+x.getAccount()+ "  Transaction_date: "+x.getTransaction_date()+"   amount : "+x.getAmount()+"  userid : "+x.getUserid()+ "  Operation: "+x.getOperation());
//   }
double a = bd.ClosingBalance(1);
        System.out.println(a);
      
    }
}
