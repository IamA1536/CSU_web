package com.a.JPetStore.persistence.impl;

import com.a.JPetStore.domain.extra.Log;
import com.a.JPetStore.persistence.DBUtil;
import com.a.JPetStore.persistence.LogDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/14 14:40
 */
public class LogDAOImpl implements LogDAO {

    private static final String INSERT_LOG = "INSERT INTO LOG ( logid, time, username, type ) VALUES( ?, ? ,?, ? )";

    @Override
    public void InsertLog(Log log) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOG);
        preparedStatement.setInt(1, log.getLogid());
        preparedStatement.setDate(2, new Date(log.getDate().getTime()));
        if (log.getAccount().getUsername() == null) {
            preparedStatement.setString(3, "guest");
        } else
            preparedStatement.setString(3, log.getAccount().getUsername());
        preparedStatement.setString(4, log.getType());

        preparedStatement.execute();
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }
}
