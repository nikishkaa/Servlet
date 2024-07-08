package org.example.demowebapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "FormServlet", value = "/form")

public class FormServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("name page" + new Date());
        request.getRequestDispatcher("/html/ageForm.html").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String Name = request.getParameter("first");
        String SecondName = request.getParameter("second");
        String Gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));

//        response.getWriter().println("<h2>Hello</h2>" + Name + " " + SecondName + "Gender " + Gender);
        if (age >= 18) {
            response.getWriter().println("<a href=\"https://www.shutterstock.com/ru/image-photo/cold-beer-glass-close-dark-pub-2340557295\">Photo</a>");
        }else{
            response.getWriter().println("<a href=\"https://www.shutterstock.com/ru/image-photo/juice-bottles-blank-label-2474065337\">Photo</a>");
        }

        return;
    }
}
