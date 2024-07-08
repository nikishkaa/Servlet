package org.example.demowebapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "RDServlet", value = "/rd-test")
public class RDServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Request: " + request.getRequestedSessionId());

        String val = Optional.ofNullable(request.getParameter("param")).orElse("empty");

        if (val.equals("page_1")) {
            RequestDispatcher rd = request.getRequestDispatcher("/html/Page_1.html");
            rd.forward(request, response);
        } else {
            response.sendRedirect("https://foreza.medium.com/learning-about-sam-single-abstract-method-and-functional-interfaces-d91cd16e6d68");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }


}
