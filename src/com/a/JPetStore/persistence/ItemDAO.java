package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.object.Item;

import java.util.List;
import java.util.Map;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/6 22:56
 */
public interface ItemDAO {
    void updateInventoryQuantity(Map<String, Object> param) throws Exception;

    int getInventoryQuantity(String itemId) throws Exception;

    List<Item> getItemListByProduct(String productId) throws Exception;

    Item getItem(String itemId) throws Exception;

}
