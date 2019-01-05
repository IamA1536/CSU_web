package com.a.JPetStore.web.servlets;

import com.a.JPetStore.serivce.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/28 12:25
 */

@WebServlet(name = "UseNameIsExistServlet", urlPatterns = {"/usenameisexist"})
public class UseNameIsExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        AccountService accountService = new AccountService();

        PrintWriter out = response.getWriter();
        try {
            if (accountService.getAccount(username) == null) {
                out.print("NotExist");
            } else {
                out.print("Exist");
            }

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
