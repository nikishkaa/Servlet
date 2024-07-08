package org.example.demowebapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;

@WebServlet(name = "gameServlet", value = "/guess-number")
public class GuessNumber extends HttpServlet {

    private Integer x;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        // /guess-number?min=1&max=10

//        if (Objects.isNull(x)) {
//            // Generate random number
//            Random random = new Random();
//
//            int from = Integer.valueOf(request.getParameter("min"));
//            int to = Integer.valueOf(request.getParameter("max"));
//
//            x = random.nextInt(from, to + 1);
//        } else {
//            int answer = Integer.valueOf(request.getParameter("answer"));
//
//            if (x == answer) {
//                printWriter.println("<h1> YOU WON!</h1>");
//
//            } else {
//                printWriter.println("<h1> YOU Lose!</h1>");
//
//            }
//        }
//        printWriter.println("<a href='guess-number?min=1&max=10'> Play Again from 1 to 10</h1>");

    }

}
