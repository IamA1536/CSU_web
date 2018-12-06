package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.object.Category;

import java.util.List;

/**
 * @author A
 * The interface use for get category.
 * Created by IamA#1536 on 2018/12/5 16:03
 */

public interface CategoryDAO {
    /**
     * get all categories
     * @return categorylist
     */
    List<Category> getCategoryList() throws Exception;

    /**
     * get a category by id
     * @param categoryId The id of category we want.
     * @return category
     */

    Category getCategory(String categoryId) throws Exception;
}
