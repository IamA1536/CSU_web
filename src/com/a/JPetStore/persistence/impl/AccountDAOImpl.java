package com.a.JPetStore.persistence.impl;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.persistence.AccountDAO;
import com.a.JPetStore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/9 22:40
 */
public class AccountDAOImpl implements AccountDAO {

    private static final String GET_ACCOUNT_BY_USERNAME = "SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT SIGNON.USERNAME, ACCOUNT.EMAIL, ACCOUNT.FIRSTNAME, ACCOUNT.LASTNAME, ACCOUNT.STATUS, ACCOUNT.ADDR1 AS address1, ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";

    private static final String INSERT_ACCOUNT = "INSERT INTO ACCOUNT(EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE, USERID) VALUES (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_PROFILE = "UPDATE PROFILE SET LANGPREF = ?,FAVCATEGORY = ? WHERE USERID = ?";

    private static final String INSERT_PROFILE = " INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";

    private static final String UPDATE_SIGNON = "UPDATE SIGNON SET PASSWORD = ? WHERE USERNAME = ?";

    private static final String INSERT_SIGNON = "INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";

    private static final String UPDATE_ACCOUNT = "UPDATE ACCOUNT SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, STATUS = ?, ADDR1 = ?, ADDR2 = ?, CITY = ?, STATE = ?, ZIP = ?, COUNTRY = ?, PHONE = ? WHERE USERID = ?";

    @Override
    public Account getAccountByUsername(String username) throws Exception {
        Account account = new Account();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            account.setUsername(resultSet.getString(1));
            account.setEmail(resultSet.getString(2));
            account.setFirstName(resultSet.getString(3));
            account.setLastName(resultSet.getString(4));
            account.setStatus(resultSet.getString(5));
            account.setAddress1(resultSet.getString(6));
            account.setAddress2(resultSet.getString(7));
            account.setCity(resultSet.getString(8));
            account.setState(resultSet.getString(9));
            account.setZip(resultSet.getString(10));
            account.setCountry(resultSet.getString(11));
            account.setPhone(resultSet.getString(12));
            account.setLanguagePreference(resultSet.getString(13));
            account.setFavouriteCategoryId(resultSet.getString(14));
            account.setListOption(resultSet.getBoolean(15));
            account.setBannerOption(resultSet.getBoolean(16));
            account.setBannerName(resultSet.getString(17));
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        if (account.getUsername() == null)
            account = null;
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) throws Exception {
        Account account1 = new Account();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            account1.setUsername(resultSet.getString(1));
            account1.setEmail(resultSet.getString(2));
            account1.setFirstName(resultSet.getString(3));
            account1.setLastName(resultSet.getString(4));
            account1.setStatus(resultSet.getString(5));
            account1.setAddress1(resultSet.getString(6));
            account1.setCity(resultSet.getString(7));
            account1.setState(resultSet.getString(8));
            account1.setZip(resultSet.getString(9));
            account1.setCountry(resultSet.getString(10));
            account1.setPhone(resultSet.getString(11));
            account1.setLanguagePreference(resultSet.getString(12));
            account1.setFavouriteCategoryId(resultSet.getString(13));
            account1.setBannerOption(resultSet.getBoolean(14));
            account1.setBannerName(resultSet.getString(15));
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        if (account1.getUsername() == null && account1.getPassword() == null)
            return null;
        return account1;
    }

    @Override
    public void insertAccount(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
        preparedStatement.setString(1, account.getEmail());
        preparedStatement.setString(2, account.getFirstName());
        preparedStatement.setString(3, account.getLastName());
        preparedStatement.setString(4, account.getStatus());
        preparedStatement.setString(5, account.getAddress1());
        preparedStatement.setString(6, account.getAddress2());
        preparedStatement.setString(7, account.getCity());
        preparedStatement.setString(8, account.getState());
        preparedStatement.setString(9, account.getZip());
        preparedStatement.setString(10, account.getCountry());
        preparedStatement.setString(11, account.getPhone());
        preparedStatement.setString(12, account.getUsername());

        preparedStatement.execute();

        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }

    @Override
    public void insertProfile(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
        preparedStatement.setString(1, account.getLanguagePreference());
        preparedStatement.setString(2, account.getFavouriteCategoryId());
        preparedStatement.setString(3, account.getUsername());

        preparedStatement.execute();


        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);


    }

    @Override
    public void insertSignon(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIGNON);
        preparedStatement.setString(1, account.getPassword());
        preparedStatement.setString(2, account.getUsername());
        preparedStatement.execute();


        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);

    }

    @Override
    public void updateAccount(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
        preparedStatement.setString(1, account.getEmail());
        preparedStatement.setString(2, account.getFirstName());
        preparedStatement.setString(3, account.getLastName());
        preparedStatement.setString(4, account.getStatus());
        preparedStatement.setString(5, account.getAddress1());
        preparedStatement.setString(6, account.getAddress2());
        preparedStatement.setString(7, account.getCity());
        preparedStatement.setString(8, account.getState());
        preparedStatement.setString(9, account.getZip());
        preparedStatement.setString(10, account.getCountry());
        preparedStatement.setString(11, account.getPhone());
        preparedStatement.setString(12, account.getUsername());

        preparedStatement.execute();


        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }

    @Override
    public void updateProfile(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE);
        preparedStatement.setString(1, account.getLanguagePreference());
        preparedStatement.setString(2, account.getFavouriteCategoryId());
        preparedStatement.setString(3, account.getUsername());

        preparedStatement.execute();

        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
    }

    @Override
    public void updateSignon(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIGNON);
        preparedStatement.setString(1, account.getPassword());
        preparedStatement.setString(2, account.getUsername());

        preparedStatement.execute();

        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);

    }
}
