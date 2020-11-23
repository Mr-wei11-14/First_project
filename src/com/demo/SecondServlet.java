package com.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet")
public class SecondServlet extends HttpServlet {
    ServletContext context = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset = gb2312");
        context = this.getServletContext();
        Student stu = (Student) context.getAttribute("first_stu");
        String name = stu.getName();
        String sno = stu.getSno();
        PrintWriter out = response.getWriter();
        out.println("该学生的学号为:" + sno + "<br/>");
        out.println("该学生的姓名为:" + name + "<br/>");
    }
}
