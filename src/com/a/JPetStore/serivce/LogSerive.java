package com.a.JPetStore.serivce;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.extra.Log;
import com.a.JPetStore.persistence.LogDAO;
import com.a.JPetStore.persistence.impl.LogDAOImpl;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/14 15:19
 */
public class LogSerive {
    private LogDAO logDAO;

    public LogSerive(){
        logDAO = new LogDAOImpl();
    }

    public void InsertLog(Account account, String type) throws Exception {
        Log log = new Log(account, type);
        logDAO.InsertLog(log);
    }

}
