package com.a.JPetStore.web.servlets;

import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/7 9:38
 */
public class SreachProductServlet extends HttpServlet {
    private String keywords;
    private static final String SREACH = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        keywords = request.getParameter("keywords");
        CatalogSerivce serivce = new CatalogSerivce();

    }
}
