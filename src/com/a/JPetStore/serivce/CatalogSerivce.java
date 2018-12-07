package com.a.JPetStore.serivce;

import com.a.JPetStore.domain.object.Category;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.domain.object.Product;
import com.a.JPetStore.persistence.CategoryDAO;
import com.a.JPetStore.persistence.ItemDAO;
import com.a.JPetStore.persistence.ProductDAO;
import com.a.JPetStore.persistence.impl.CategoryDAOImpl;
import com.a.JPetStore.persistence.impl.ItemDAOImpl;
import com.a.JPetStore.persistence.impl.ProductDAOImpl;

import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 17:42
 */
public class CatalogSerivce {

    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;

    public CatalogSerivce(){
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }

    public List<Category> getCategoryList() throws Exception {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) throws Exception {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) throws Exception {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) throws Exception {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) throws Exception {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId) throws Exception {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) throws Exception {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) throws Exception {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
