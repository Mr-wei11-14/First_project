package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookie")
public class GetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String cookieName = "user";
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(cookieName)) {
                    cookieValue = cookie.getValue();
                }
            }
        }

        out.println("<html><title>get cookies</title>");
        out.println("<body><h2>A cookie has been got from brower</h2>");
        out.println("CookieName:" + cookieName + "<br>");
        out.println("CookieValue:" + cookieValue + "<br>");

        out.println("</body></html>");
    }
}
