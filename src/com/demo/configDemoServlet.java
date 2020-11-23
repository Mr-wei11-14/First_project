package com.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.demo.configDemoServlet")
public class configDemoServlet extends HttpServlet {
    String servletName = null;
    ServletConfig config = null;
    String email = null;
    String telephone = null;

    public void init() {
        config = getServletConfig();
        servletName = config.getServletName();
        //email = config.getInitParameter("email");
        //telephone = config.getInitParameter("telephone");
        ServletContext context = this.getServletContext();
        email = context.getInitParameter("email");
        telephone = context.getInitParameter("telephone");
        //将e-mail地址，电话信息写入日志文件中
        context.log(email);
        context.log(telephone);
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Servlet名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
