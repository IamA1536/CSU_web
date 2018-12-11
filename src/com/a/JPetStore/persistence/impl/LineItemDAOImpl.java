package com.a.JPetStore.persistence.impl;

import com.a.JPetStore.domain.orders.LineItem;
import com.a.JPetStore.persistence.DBUtil;
import com.a.JPetStore.persistence.LineItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 0:22
 */
public class LineItemDAOImpl implements LineItemDAO {
    private static final String GET_LINE_ITEMS_BY_ORDERID = "SELECT ORDERID,LINENUM AS lineNumber,ITEMID, QUANTITY, UNITPRICE FROM LINEITEM WHERE ORDERID = ?";
    private static final String INSERT_LINE_ITEM = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) throws Exception {
        List<LineItem> lineItemList = new ArrayList<LineItem>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_LINE_ITEMS_BY_ORDERID);
        preparedStatement.setInt(1, orderId);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            LineItem lineItem = new LineItem();
            lineItem.setOrderId(resultSet.getInt(1));
            lineItem.setLineNumber(resultSet.getInt(2));
            lineItem.setItemId(resultSet.getString(3));
            lineItem.setQuantity(resultSet.getInt(4));
            lineItem.setUnitPrice(resultSet.getBigDecimal(5));
            lineItemList.add(lineItem);
        }

        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);

        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LINE_ITEM);
        preparedStatement.setInt(1, lineItem.getOrderId());
        preparedStatement.setInt(2, lineItem.getLineNumber());
        preparedStatement.setString(3, lineItem.getItemId());
        preparedStatement.setInt(4, lineItem.getQuantity());
        preparedStatement.setBigDecimal(5, lineItem.getUnitPrice());

        preparedStatement.execute();

        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }
}
