package com.a.JPetStore.serivce;

import com.a.JPetStore.domain.extra.Sequence;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.domain.orders.LineItem;
import com.a.JPetStore.domain.orders.Order;
import com.a.JPetStore.persistence.ItemDAO;
import com.a.JPetStore.persistence.LineItemDAO;
import com.a.JPetStore.persistence.OrderDAO;
import com.a.JPetStore.persistence.SequenceDAO;
import com.a.JPetStore.persistence.impl.ItemDAOImpl;
import com.a.JPetStore.persistence.impl.LineItemDAOImpl;
import com.a.JPetStore.persistence.impl.OrderDAOImpl;
import com.a.JPetStore.persistence.impl.SequenceDAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 0:36
 */
public class OrderSerive {
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    public OrderSerive() {
        itemDAO = new ItemDAOImpl();
        orderDAO = new OrderDAOImpl();
        sequenceDAO = new SequenceDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
    }

    public void insertOrder(Order order) throws Exception {
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            String itemId = lineItem.getItemId();

            Integer increment = new Integer(lineItem.getQuantity());
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("itemId", itemId);
            param.put("increment", increment);
            System.out.println(increment);
            itemDAO.updateInventoryQuantity(param);
        }

        orderDAO.insertOrder(order);
        orderDAO.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemDAO.insertLineItem(lineItem);
        }
    }

    public Order getOrder(int orderId) throws Exception {
        Order order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            Item item = itemDAO.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    public List<Order> getOrdersByUsername(String username) throws Exception {
        return orderDAO.getOrdersByUsername(username);
    }

    public int getNextId(String name) throws Exception {
        Sequence sequence = new Sequence(name, -1);
        sequence = (Sequence) sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }
}
