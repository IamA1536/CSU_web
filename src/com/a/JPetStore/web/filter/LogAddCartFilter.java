package com.a.JPetStore.web.filter;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.carts.Cart;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.serivce.CatalogSerivce;
import com.a.JPetStore.serivce.LogSerive;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/16 10:26
 */
public class LogAddCartFilter implements Filter {

    private static final String V_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String workingItemId;
    private Cart cart;

    private CatalogSerivce catalogSerivce;

    private Account account;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        workingItemId = request.getParameter("workingItemId");
        HttpSession session = ((HttpServletRequest)request).getSession();
        cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);
        if (account == null) {
            String message = "Please sign in first!";
            session.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
            return;
        }
        if (cart == null)
            cart = new Cart();
        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
            session.setAttribute("cart", cart);
            LogSerive logSerive = new LogSerive();
            try {
                Item item = catalogSerivce.getItem(workingItemId);
                String str = account.getUsername() + "adds" + item.getItemId() + "to cart";
                logSerive.InsertLog(account, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher(V_CART).forward(request, response);
        } else {
            catalogSerivce = new CatalogSerivce();
            try {
                boolean isInStock = catalogSerivce.isItemInStock(workingItemId);
                Item item = catalogSerivce.getItem(workingItemId);
                cart.addItem(item, isInStock);
                session.setAttribute("cart", cart);

                LogSerive logSerive = new LogSerive();
                String str = "Adds " + item.getItemId() + " to cart";
                logSerive.InsertLog(account, str);

                request.getRequestDispatcher(V_CART).forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
