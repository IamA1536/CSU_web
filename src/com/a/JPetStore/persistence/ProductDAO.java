package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.object.Product;

import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 17:17
 */
public interface ProductDAO {
    List<Product> getProductListByCategory(String categoryId) throws Exception;

    Product getProduct(String productId) throws Exception;

    List<Product> searchProductList(String keywords) throws Exception;
}
