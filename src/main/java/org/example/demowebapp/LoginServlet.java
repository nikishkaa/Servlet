package org.example.demowebapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Login page" + new Date());
        request.getRequestDispatcher("/html/login.html").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String userName = request.getParameter("first");
        String userPassword = request.getParameter("password");

        // Check in BD
        if (userName.equalsIgnoreCase("John")) {
            if (userPassword.equals("1234")) {
                response.getWriter().println("welcome john");
                return;
            } else {
                // include
                response.getWriter().println("<h2>Incorrect Username or Password</h2>");

                RequestDispatcher rd = request.getRequestDispatcher("/html/login.html");
                rd.include(request, response);


                return;
            }
        }
    }

}
