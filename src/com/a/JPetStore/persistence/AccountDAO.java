package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.account.Account;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/9 22:34
 */
public interface AccountDAO {

    Account getAccountByUsername(String username) throws Exception;

    Account getAccountByUsernameAndPassword(Account account) throws Exception;

    void insertAccount(Account account) throws Exception;

    void insertProfile(Account account) throws Exception;

    void insertSignon(Account account) throws Exception;

    void updateAccount(Account account) throws Exception;

    void updateProfile(Account account) throws Exception;

    void updateSignon(Account account) throws Exception;
}
