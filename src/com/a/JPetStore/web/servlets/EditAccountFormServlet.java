package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.serivce.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/10 22:26
 */
public class EditAccountFormServlet extends HttpServlet {
    private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";

    private AccountService accountService;

    private Account account;
    private int IsEdit;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
        session.setAttribute("account", account);

        String password = request.getParameter("password");
        if (password != null){
            String repeatedPassword = request.getParameter("repeatedPassword");
            if (!password.equals(repeatedPassword)){
                String error = "Entered passwords differ!";
                session.setAttribute("error",error);
                request.getRequestDispatcher(EDIT_ACCOUNT).forward(request, response);
                return;
            }
        }
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setEmail(request.getParameter("email"));
        account.setPhone(request.getParameter("phone"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setCity(request.getParameter("city"));

        accountService = new AccountService();

        request.getRequestDispatcher(EDIT_ACCOUNT).forward(request, response);
    }
}
