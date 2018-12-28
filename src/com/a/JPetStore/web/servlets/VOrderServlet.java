package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.orders.Order;
import com.a.JPetStore.serivce.LogSerive;
import com.a.JPetStore.serivce.OrderSerive;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/11 17:58
 */
@WebServlet(name = "VOrderServlet", urlPatterns = {"/vorder"})
public class VOrderServlet extends HttpServlet {
    private static final String V_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private Account account;
    private Order order;
    private OrderSerive orderSerive;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        order = (Order) session.getAttribute("order");
        session.setAttribute("account", account);
        session.setAttribute("order", order);

        orderSerive = new OrderSerive();
        try {
            orderSerive.insertOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogSerive logSerive = new LogSerive();
        String str = "Make a order:" + order.getOrderId();
        try {
            logSerive.InsertLog(account, str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher(V_ORDER).forward(request, response);
    }
}
