package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.orders.Order;
import com.a.JPetStore.serivce.OrderSerive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 12:26
 */
public class ListOrdersServlet extends HttpServlet {
    private static final String LISTORDER = "/WEB-INF/jsp/order/ListOrders.jsp";
    private Account account;
    //    private Order order;
    private OrderSerive orderSerive;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
//        order = (Order) session.getAttribute("order");
        session.setAttribute("account", account);
        orderSerive = new OrderSerive();
//        order = new Order();
        try {
            List<Order> orderList = new ArrayList<Order>();
            orderList = orderSerive.getOrdersByUsername(account.getUsername());
            session.setAttribute("orderList", orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        session.setAttribute("order", order);

        request.getRequestDispatcher(LISTORDER).forward(request, response);
    }
}
