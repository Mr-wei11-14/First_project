package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ShowSession")
public class ShowSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String heading = null;
        Integer accessCount = (Integer)session.getAttribute("accessCount");

        if (accessCount == null) {
            accessCount = new Integer(0);
            heading = "Welcome Back";
        } else {
            heading = "Welcome Back";
            accessCount = new Integer(accessCount.intValue() + 1);
        }
        session.setAttribute("accessCount", accessCount);

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Session Tracking Example</title></head>");
        out.println("<body><center>");
        out.println("<h1>" + heading + "</h1>");
        out.println("<h2>Information about your session</h2>");
        out.println("<table border = '1'>");
        out.println("<tr bgcolor=\"ffad00\"><th>Info Type<th>Value\n");
        out.println("<tr><td>ID<td>" + session.getId() + "\n");
        out.println("<tr><td>Creation Time:<td>");
        out.println("" + new Date(session.getCreationTime()) + "\n");
        out.println("<tr><td>Time of last access:<td>");
        out.println("" + new Date(session.getLastAccessedTime()) + "\n");
        out.println("<tr><td>Access number:<td>"  + accessCount + "\n");
        out.println("</table></center></body></html>");
    }
}
