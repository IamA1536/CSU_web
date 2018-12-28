package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
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
 * Created by IamA#1536 on 2018/12/7 9:38
 */
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/search"})
public class SearchProductServlet extends HttpServlet {
    private String keyword;
    private Account account;
    private static final String SEARCH = "/WEB-INF/jsp/catalog/SearchProducts.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keyword = request.getParameter("keyword");
        CatalogSerivce service = new CatalogSerivce();
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);
        try {
            List<Product> productList = service.searchProductList(keyword);


            session.setAttribute("productList", productList);

            request.getRequestDispatcher(SEARCH).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
