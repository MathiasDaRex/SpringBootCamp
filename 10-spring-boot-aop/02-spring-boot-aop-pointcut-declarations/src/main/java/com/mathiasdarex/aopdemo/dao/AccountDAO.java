package com.mathiasdarex.aopdemo.dao;


import com.mathiasdarex.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}
