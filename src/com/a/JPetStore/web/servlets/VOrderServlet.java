package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.orders.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/11 17:58
 */
public class VOrderServlet extends HttpServlet {
    private static final String V_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private static final String NEWOEDERFORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private Account account;
    private Order order;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        order = (Order) session.getAttribute("order");
        session.setAttribute("account", account);

        if (order == null) {
            request.getRequestDispatcher(NEWOEDERFORM).forward(request, response);
        } else {
            session.setAttribute("order", order);
            request.getRequestDispatcher(V_ORDER).forward(request, response);
        }
    }
}
