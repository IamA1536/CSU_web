package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.orders.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/11 21:21
 */
@WebServlet(name = "ShippingFormServlet", urlPatterns = {"/shippingform"})
public class ShippingFormServlet extends HttpServlet {
    private Order order;
    private Account account;
    private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String VIEWORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);
        if (order == null) {
            order = (Order) session.getAttribute("order");
            request.getRequestDispatcher(SHIPPINGFORM).forward(request, response);
        } else {
            order.setShipToFirstName(request.getParameter("shiptofirstName"));
            order.setShipToLastName(request.getParameter("shiptolastName"));
            order.setShipAddress1(request.getParameter("shipaddress1"));
            order.setShipAddress2(request.getParameter("shipaddress2"));
            order.setShipCity(request.getParameter("shipcity"));
            order.setShipState(request.getParameter("shipstate"));
            order.setShipZip(request.getParameter("shipzip"));
            order.setShipCountry(request.getParameter("shipcountry"));
            session.setAttribute("order", order);
            request.getRequestDispatcher(VIEWORDER).forward(request, response);
        }
    }
}
