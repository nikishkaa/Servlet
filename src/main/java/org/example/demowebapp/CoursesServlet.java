package org.example.demowebapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "courseServlet", value = "/cours")
public class CoursesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><b>Currencies</b><html><table border// =\"0\" width=\"80%\"><tr><th>#</th><th>ID</th><th>Rate</th></tr><tr bgcolor='white'><td>1</td><td>USD</td><td>3.209</td></tr></table></html>\n<body>");
    }
}
