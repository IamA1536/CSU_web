package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.carts.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 17:45
 */
@WebServlet(name = "VCartServlet", urlPatterns = {"/vcart"})
public class VCartServlet extends HttpServlet {
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String V_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private Account account;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);

        if (account == null) {
            String message = "Please sign in first!";
            session.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
            return;
        }

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        request.getRequestDispatcher(V_CART).forward(request, response);
    }
}
