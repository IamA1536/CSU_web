package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    private Account account;

    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        account = (Account) session.getAttribute("account");
        request.setAttribute("account", account);
        request.getRequestDispatcher(MAIN).forward(request, response);
    }
}
