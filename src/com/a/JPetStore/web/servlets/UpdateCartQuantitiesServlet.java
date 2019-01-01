package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.carts.Cart;
import com.a.JPetStore.domain.carts.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 23:50
 */
@WebServlet(name = "UpdateCartQuantitiesServlet", urlPatterns = {"/updatecartquantities"})
public class UpdateCartQuantitiesServlet extends HttpServlet {

    private static final String V_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    private Cart cart;
    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);

        Iterator<CartItem> cartItemIterator = cart.getAllCartItems();

        String temp = null;
        while (cartItemIterator.hasNext()) {
            CartItem cartItem = (CartItem) cartItemIterator.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt((String) request.getParameter(itemId));
                if (quantity > 0)
                    cart.setQuantityByItemId(itemId, quantity);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                temp = itemId;
            }
        }

        if (temp != null)
            cart.removeItemById(temp);

        request.getRequestDispatcher(V_CART).forward(request, response);
    }
}
