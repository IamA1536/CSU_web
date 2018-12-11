package com.a.JPetStore.persistence.impl;

import com.a.JPetStore.domain.extra.Sequence;
import com.a.JPetStore.persistence.DBUtil;
import com.a.JPetStore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 0:38
 */
public class SequenceDAOImpl implements SequenceDAO {
    private static final String GET_SEQUENCE = "SELECT name, nextid FROM SEQUENCE WHERE NAME = ?";
    private static final String UPDATE_SEQUENCE = "UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";

    @Override
    public Sequence getSequence(Sequence sequence) throws Exception {
        Sequence sequence1 = new Sequence();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_SEQUENCE);
        preparedStatement.setString(1, sequence.getName());

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            sequence1.setName(resultSet.getString(1));
            sequence1.setNextId(resultSet.getInt(2));
        }

        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return sequence1;
    }

    @Override
    public void updateSequence(Sequence sequence) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEQUENCE);
        preparedStatement.setInt(1, sequence.getNextId());
        preparedStatement.setString(2, sequence.getName());

        preparedStatement.execute();

        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }
}
