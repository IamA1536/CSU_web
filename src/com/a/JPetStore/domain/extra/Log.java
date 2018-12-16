package com.a.JPetStore.domain.extra;

import com.a.JPetStore.domain.account.Account;

import java.util.Calendar;
import java.util.Date;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/14 14:36
 */
public class Log {
    private int logid;
    private Date date;
    private Account account;
    private String type;

    public Log() {
    }

    public Log(Account account, String type) {
        this.account = account;
        this.type = type;
        Calendar c = Calendar.getInstance();
        String str = String.valueOf(c.get(Calendar.MONTH)) + String.valueOf(c.get(Calendar.DATE)) + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + String.valueOf(c.get(Calendar.MINUTE)) + String.valueOf(c.get(Calendar.SECOND));
        logid = Integer.valueOf(str).intValue();
        date = new Date();

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
