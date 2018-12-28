package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.domain.object.Product;
import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 9:01
 */
@WebServlet(name = "VProductServlet", urlPatterns = {"/vproduct"})
public class VProductServlet extends HttpServlet {
    private String productId;
    private Account account;
    private static final String V_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productId = request.getParameter("productId");
        CatalogSerivce serivce = new CatalogSerivce();
        try {
            Product product = serivce.getProduct(productId);
            List<Item> itemList = serivce.getItemListByProduct(productId);

            HttpSession session = request.getSession();
            session.setAttribute("product", product);
            session.setAttribute("itemList", itemList);

            account = (Account) session.getAttribute("account");
            session.setAttribute("account", account);

            request.getRequestDispatcher(V_PRODUCT).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
