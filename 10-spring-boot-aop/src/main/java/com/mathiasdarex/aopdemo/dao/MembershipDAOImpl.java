package com.mathiasdarex.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");


    }

    @Override
    public Boolean addSillyMember(Integer x, Integer y) {

        System.out.println(getClass() + ": ADDING MY SILLY MEMBER WITH NUMBERS: " + x + " " + y);
        return null;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }
}
