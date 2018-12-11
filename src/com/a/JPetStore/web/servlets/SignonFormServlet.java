package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.serivce.AccountService;
import com.a.JPetStore.serivce.CatalogSerivce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/9 22:24
 */
public class SignonFormServlet extends HttpServlet {

    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    private AccountService accountService;
    private Account account;
    private CatalogSerivce catalogSerivce;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService = new AccountService();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        account = (Account) session.getAttribute("account");
        if (username == null || password == null) {
                request.getRequestDispatcher(SIGNON).forward(request, response);
        } else {
            try {
                account = accountService.getAccount(username, password);
                if (account == null) {
                    session.setAttribute("message", "Invalid username or password.  Signon failed.");
                    request.getRequestDispatcher(ERROR).forward(request, response);
                } else {
                    session.setAttribute("account", account);
                    request.getRequestDispatcher(MAIN).forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
