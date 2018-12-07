package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.carts.Cart;
import com.a.JPetStore.domain.object.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 17:55
 */
public class RemoveItemFromCartServlet extends HttpServlet {

    private static final String V_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";


    private String workingItemId;
    private Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");
        HttpSession session = request.getSession();

        cart = (Cart) session.getAttribute("cart");
        Item item = cart.removeItemById(workingItemId);
        if (item == null) {
            session.setAttribute("message", "Attempted to remove null CartItem from Cart.");
            request.getRequestDispatcher(ERROR).forward(request, response);
        } else {
            request.getRequestDispatcher(V_CART).forward(request, response);
        }
    }
}
