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
 * Created by IamA#1536 on 2018/12/12 12:38
 */
public class NewAccountFormServlet extends HttpServlet {
    private static final String NEWACCOUNTFORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Account account = new Account();
        if (username == null) {
            String error = "Please input the username!";
            session.setAttribute("error", error);
            request.getRequestDispatcher(NEWACCOUNTFORM).forward(request, response);
            return;
        }
        if (password == null) {
            String error = "Please input the password!";
            session.setAttribute("error", error);
            request.getRequestDispatcher(NEWACCOUNTFORM).forward(request, response);
            return;
        }
        if (email == null) {
            String error = "Please input the email!";
            session.setAttribute("error", error);
            request.getRequestDispatcher(NEWACCOUNTFORM).forward(request, response);
            return;
        } else {
            String repeatpassword = request.getParameter("repeatedPassword");
            if (!password.equals(repeatpassword)){
                String error = "Entered passwords differ!";
                session.setAttribute("error", error);
                request.getRequestDispatcher(NEWACCOUNTFORM).forward(request, response);
                return;
            }
        }
        account.setUsername(username);
        account.setPassword(password);
        String error = "";
        session.setAttribute("error", error);
        if (request.getParameter("email") != null) {
            account.setFirstName(request.getParameter("firstName"));
            account.setLastName(request.getParameter("lastName"));
            account.setEmail(request.getParameter("email"));
            account.setPhone(request.getParameter("phone"));
            account.setAddress1(request.getParameter("address1"));
            account.setAddress2(request.getParameter("address2"));
            account.setCity(request.getParameter("city"));
            account.setState(request.getParameter("state"));
            account.setZip(request.getParameter("zip"));
            account.setCountry(request.getParameter("country"));
            account.setLanguagePreference(request.getParameter("languagePreference"));
            account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
            if (request.getParameter("listoption") != null)
                account.setListOption(true);
            else account.setListOption(false);
            if (request.getParameter("banneroption") != null)
                account.setBannerOption(true);
            else account.setBannerOption(false);
        }
        accountService = new AccountService();
        try {
            accountService.insertAccount(account);
            session.setAttribute("account", account);
            request.getRequestDispatcher(MAIN).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
