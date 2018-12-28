package com.a.JPetStore.web.servlets;

import com.a.JPetStore.domain.extra.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 16:57
 */
@WebServlet(name = "VerifyCodeServlet", urlPatterns = {"/verifycode"})
public class VerifyCodeServlet extends HttpServlet {
    private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username;
        String password;
        username = request.getParameter("username");
        password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("password", password);

//        request.getRequestDispatcher(SIGNONFORM).forward(request, response);
        //��������
        VerifyCode vc = new VerifyCode();
        //��ȡͼƬ����
        BufferedImage bi = vc.getImage();
        //���ͼƬ���ı�����
        String text = vc.getText();
        // ��ϵͳ���ɵ��ı����ݱ��浽session��
        request.getSession().setAttribute("text", text);
        //����������ͼƬ

        vc.output(bi, response.getOutputStream());


    }
}
