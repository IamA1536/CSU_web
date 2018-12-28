package com.a.JPetStore.web.filter;

import com.a.JPetStore.domain.account.Account;
import com.a.JPetStore.domain.object.Item;
import com.a.JPetStore.serivce.CatalogSerivce;
import com.a.JPetStore.serivce.LogSerive;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/16 10:26
 */
@WebFilter(filterName = "LogAddCartFilter", urlPatterns = {"/AddItemToCart"})
public class LogAddCartFilter implements Filter {

    private String workingItemId;

    private CatalogSerivce catalogSerivce;

    private Account account;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        workingItemId = request.getParameter("workingItemId");
        HttpSession session = ((HttpServletRequest) request).getSession();
        account = (Account) session.getAttribute("account");
        catalogSerivce = new CatalogSerivce();
        try {
            Item item = catalogSerivce.getItem(workingItemId);
            LogSerive logSerive = new LogSerive();
            String str = "Adds " + item.getItemId() + " to cart";
            logSerive.InsertLog(account, str);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
