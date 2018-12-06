package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.object.Category;
import com.a.JPetStore.domain.object.Product;
import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/5 17:51
 */
public class VCategoryServlet extends HttpServlet {

    private static final String V_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private String categoryId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryId = request.getParameter("categoryId");
        CatalogSerivce service = new CatalogSerivce();

        try {
            Category category = service.getCategory(categoryId);
            List<Product> productList = service.getProductListByCategory(categoryId);
            HttpSession session = request.getSession();
            session.setAttribute("category", category);
            session.setAttribute("productList", productList);

            request.getRequestDispatcher(V_CATEGORY).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
