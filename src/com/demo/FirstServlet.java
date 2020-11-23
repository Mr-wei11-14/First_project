package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单传的值
        String stu_name = request.getParameter("stu_name");
        String stu_sno = request.getParameter("stu_num");
        //创建Student对象并赋值
        Student stu = new Student();
        stu.setName(stu_name);
        stu.setSno(stu_sno);
        //将其作为属性存储在ServletContext对象
        ServletContext context = this.getServletContext();
        context.setAttribute("first_stu", stu);

        RequestDispatcher rd = context.getRequestDispatcher("/SecondServlet");
        rd.forward(request, response);
    }
}
