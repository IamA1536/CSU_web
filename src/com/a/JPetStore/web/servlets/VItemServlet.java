package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.domain.object.Product;
import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 10:19
 */
public class VItemServlet extends HttpServlet {
    private static final String V_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private String itemId;
    private String productId;
    private Account account;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");
        productId = request.getParameter("productId");
        CatalogSerivce serivce = new CatalogSerivce();
        try {
            Item item = serivce.getItem(itemId);
            Product product = serivce.getProduct(productId);

            HttpSession session = request.getSession();
            session.setAttribute("item", item);
            session.setAttribute("product", product);

            account = (Account) session.getAttribute("account");
            session.setAttribute("account", account);


            request.getRequestDispatcher(V_ITEM).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
