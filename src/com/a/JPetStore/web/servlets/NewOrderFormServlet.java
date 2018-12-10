package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/10 14:23
 */
public class NewOrderFormServlet extends HttpServlet {

    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String NEWOEDERFORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private Account account;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);
        if (account == null) {
            String message = "Please sign in first!";
            session.setAttribute("message", message);
            request.getRequestDispatcher(ERROR).forward(request, response);
        } else {

            request.getRequestDispatcher(NEWOEDERFORM).forward(request, response);
        }

    }
}
