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
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        // 将系统生成的文本内容保存到session中
        request.getSession().setAttribute("text", text);
        //向浏览器输出图片

        vc.output(bi, response.getOutputStream());


    }
}
