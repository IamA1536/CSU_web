package com.a.JPetStore.serivce;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.persistence.AccountDAO;
import com.a.JPetStore.persistence.impl.AccountDAOImpl;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/9 22:56
 */
public class AccountService {
    private AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAOImpl();
    }

    public Account getAccount(String username) throws Exception {
        return accountDAO.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) throws Exception {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        return accountDAO.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) throws Exception {
        accountDAO.insertAccount(account);
        accountDAO.insertProfile(account);
        accountDAO.insertSignon(account);
    }

    public void updateAccount(Account account) throws Exception {
        accountDAO.updateAccount(account);
        accountDAO.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountDAO.updateSignon(account);
        }
    }
}
