package com.a.JPetStore.persistence.impl;

import com.a.JPetStore.domain.object.Category;
import com.a.JPetStore.persistence.CategoryDAO;
import com.a.JPetStore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 16:13
 */
public class CategoryDAOImpl implements CategoryDAO {
    private static final String GET_CATEGORY_LIST = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
    //    private static final String GET_CATEGORY = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = #{categoryId}";
    private static final String GET_CATEGORY = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = ";

    @Override
    public List<Category> getCategoryList() throws Exception {
        List<Category> categoryList = new ArrayList<Category>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_LIST);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Category category = new Category();
            category.setCategoryId(resultSet.getString(1));
            category.setName(resultSet.getString(2));
            category.setDescription(resultSet.getString(3));
            categoryList.add(category);
        }
        DBUtil.closeResultSet(resultSet);
        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeConnection(connection);
        return categoryList;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public Category getCategory(String categoryId) throws Exception {
        Category category = null;
        Connection connection = DBUtil.getConnection();

//        PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY);
//        preparedStatement.setString(1, categoryId);
//        ResultSet resultSet = preparedStatement.executeQuery();
        String str = GET_CATEGORY + "'" + categoryId + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(str);
        if (resultSet.next()) {
            category = new Category();
            category.setCategoryId(resultSet.getString(1));
            category.setName(resultSet.getString(2));
            category.setDescription(resultSet.getString(3));

        }
        DBUtil.closeResultSet(resultSet);
//        DBUtil.closePreparedstatement(preparedStatement);
        DBUtil.closeStatement(statement);
        DBUtil.closeConnection(connection);
        return category;
    }
}
