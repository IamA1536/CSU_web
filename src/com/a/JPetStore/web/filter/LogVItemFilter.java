package com.a.JPetStore.web.filter;


import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.domain.object.Product;
import com.a.JPetStore.serivce.CatalogSerivce;
import com.a.JPetStore.serivce.LogSerive;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/16 9:58
 */
public class LogVItemFilter implements Filter {
    private static final String V_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private String itemId;
    private String productId;
    private Account account;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        itemId = request.getParameter("itemId");
        productId = request.getParameter("productId");
        CatalogSerivce serivce = new CatalogSerivce();

        try {
            Item item = serivce.getItem(itemId);
            Product product = serivce.getProduct(productId);

            session.setAttribute("item", item);
            session.setAttribute("product", product);

            account = (Account) session.getAttribute("account");
            session.setAttribute("account", account);

            LogSerive logSerive = new LogSerive();
            String str = "Views " + item.getItemId();
            logSerive.InsertLog(account, str);

            request.getRequestDispatcher(V_ITEM).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
