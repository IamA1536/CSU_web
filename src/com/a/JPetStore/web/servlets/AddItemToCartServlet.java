package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.carts.Cart;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 16:53
 */
public class AddItemToCartServlet extends HttpServlet {

    private static final String V_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    private String workingItemId;
    private Cart cart;

    private CatalogSerivce catalogSerivce;

    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        workingItemId = request.getParameter("workingItemId");


        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");


        if (cart == null)
            cart = new Cart();
        if (cart.containsItemId(workingItemId))
            cart.incrementQuantityByItemId(workingItemId);
        else {
            catalogSerivce = new CatalogSerivce();
            try {
                boolean isInStock = catalogSerivce.isItemInStock(workingItemId);
                Item item = catalogSerivce.getItem(workingItemId);

                cart.addItem(item, isInStock);

            } catch (Exception e) {
                e.printStackTrace();
            }

            session.setAttribute("cart", cart);
            session.setAttribute("account", account);
            request.getRequestDispatcher(V_CART).forward(request, response);
        }
    }
}
