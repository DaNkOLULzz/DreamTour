package com.softserve.academy.dreamtour.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    private String[] loginRequiredUrls = { "/HotelPageServlet" };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        String loginUri = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginUri);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpResponse.sendRedirect("/");
        } else if (!isLoggedIn && isLoginRequired()) {
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            httpResponse.sendRedirect("login");
        } else {
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginRequired() {

        String requestUrl = httpRequest.getRequestURL().toString();

        for (String loginRequiredUrl : loginRequiredUrls) {
            if (requestUrl.contains(loginRequiredUrl)) {
                return true;
            }
        }

        return false;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

}