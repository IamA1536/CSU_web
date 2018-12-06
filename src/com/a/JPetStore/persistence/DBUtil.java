package com.a.JPetStore.persistence;

import java.sql.*;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 16:14
 */
public class DBUtil {
    private static String driverStr = "com.mysql.cj.jdbc.Driver";
    //新的是com.mysql.cj.jdbc.Driver
    private static String connectionStr = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC";
    //可能遇到时区问题，要加上?serverTimezone=UTC
    private static String username = "root";
    private static String password = "201269";

    public static Connection getConnection() throws Exception {
        Connection connection = null;
        Class.forName(driverStr);
        connection = DriverManager.getConnection(connectionStr, username, password);
        return connection;
    }

    public static void closeStatement(Statement statement) throws Exception {
        statement.close();
    }

    public static void closePreparedstatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    public static void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

//    public static void main(String[] args) throws Exception {
//        String categoryId = "BIRDS";
//        String GET_CATEGORY_LIST = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
//        String GET_CATEGORY = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = '" + categoryId + "'";
//
//        Connection connection = DBUtil.getConnection();
//        System.out.println(connection);
////        PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_LIST);
////        preparedStatement.setString(1, "BIRDS");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(GET_CATEGORY);
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//        }
//    }
}
