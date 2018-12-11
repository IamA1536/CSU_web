package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.orders.LineItem;

import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/11 23:17
 */
public interface LineItemDAO {
    List<LineItem> getLineItemsByOrderId(int orderId) throws Exception;

    void insertLineItem(LineItem lineItem) throws Exception;
}
