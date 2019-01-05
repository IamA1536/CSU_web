package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.carts.Cart;
import com.a.JPetStore.domain.orders.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/10 14:23
 */
@WebServlet(name = "NewOrderFormServlet", urlPatterns = {"/neworderform"})
public class NewOrderFormServlet extends HttpServlet {

    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String NEWOEDERFORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String CONFIRMORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private Account account;
    private Order order;
    private Cart cart;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);
        cart = (Cart) session.getAttribute("cart");

        if (account == null) {
            String message = "Please sign in first!";
            session.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
        } else if (request.getParameter("creditcard") == null) {
            order = new Order();
            order.initOrder(account, cart);
            Calendar c = Calendar.getInstance();
            String str = String.valueOf(c.get(Calendar.MONTH)) + String.valueOf(c.get(Calendar.DATE)) + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + String.valueOf(c.get(Calendar.MINUTE)) + String.valueOf(c.get(Calendar.SECOND));
            int orderId = Integer.valueOf(str).intValue();
            order.setOrderId(orderId);
            session.setAttribute("order", order);
            request.getRequestDispatcher(NEWOEDERFORM).forward(request, response);
        } else {
            order.setCreditCard(request.getParameter("creditcard"));
            order.setExpiryDate(request.getParameter("expirydate"));
            order.setCardType(request.getParameter("cardtype"));
            order.setShipToFirstName(request.getParameter("shiptofirstName"));
            order.setShipToLastName(request.getParameter("shiptolastName"));
            order.setShipAddress1(request.getParameter("shipaddress1"));
            order.setShipAddress2(request.getParameter("shipaddress2"));
            order.setShipCity(request.getParameter("shipcity"));
            order.setShipState(request.getParameter("shipstate"));
            order.setShipZip(request.getParameter("shipzip"));
            order.setShipCountry(request.getParameter("shipcountry"));
            session.setAttribute("order", order);

//            String shippingAddressRequired = request.getParameter("shippingAddressRequired");
//            if (shippingAddressRequired != null)
//                request.getRequestDispatcher(SHIPPINGFORM).forward(request, response);
//            else
            request.getRequestDispatcher(CONFIRMORDER).forward(request, response);
        }


    }
}
