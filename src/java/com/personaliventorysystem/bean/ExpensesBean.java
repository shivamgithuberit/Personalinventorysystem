/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.bean;

/**
 *
 * @author HP
 */
public class ExpensesBean {
    int exp_id;
    String exp_ac;
    int userid;
    int exp_catid;
    double amount;
    String transaction_date;
    String payby;
    String remark;

    public ExpensesBean() {
    }

    public ExpensesBean(int exp_id, String exp_ac, int userid, int exp_catid, double amount, String transaction_date, String payby, String remark) {
        this.exp_id = exp_id;
        this.exp_ac = exp_ac;
        this.userid = userid;
        this.exp_catid = exp_catid;
        this.amount = amount;
        this.transaction_date = transaction_date;
        this.payby = payby;
        this.remark = remark;
    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }

    public String getExp_ac() {
        return exp_ac;
    }

    public void setExp_ac(String exp_ac) {
        this.exp_ac = exp_ac;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getExp_catid() {
        return exp_catid;
    }

    public void setExp_catid(int exp_catid) {
        this.exp_catid = exp_catid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getPayby() {
        return payby;
    }

    public void setPayby(String payby) {
        this.payby = payby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

   
}
