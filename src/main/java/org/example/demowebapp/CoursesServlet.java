package org.example.demowebapp;

import org.apache.commons.lang3.StringUtils;
import org.example.demowebapp.service.XMLCurrencyParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.demowebapp.utils.ServletUtils.*;

@WebServlet(name = "CoursesServlet", value = "/rate-request")
public class CoursesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String path = "currencies_request_form";

        if (StringUtils.isBlank(request.getParameter("amount"))) {
            // 0. Show currencies request form
            forward("currencies_request_form", request, response);
            return;
        }

        // 1. amount & currencies are presented -> client request to calculate
        // 1.1 gat param values
        long amount = getLongParameter(request, "amount");
        String code = request.getParameter("code");

        // 1.2 Get Currency Rate
        double rate = Double.parseDouble(XMLCurrencyParser.getCurrency(code));

        if (code.equals("643")) {
            rate /= 100;
        }

        // 1.3 Calculate final Amount
        double result = amount * rate;

        // 1.4 Make response
        include(path, "Result Amount" + result, request, response);
        return;


//        response.setContentType("text/html");
//        HTMLTableBuilder currencies = new HTMLTableBuilder("Currencies", true, 3, 3, 10, 10, 10);
//        currencies.addTableHeader("#", "ID", "Rate");
//        currencies.addRowValues("1", "USD", XMLCurrencyParser.getCurrency("840"));
//        currencies.addRowValues("2", "eur", XMLCurrencyParser.getCurrency("978"));
//        currencies.addRowValues("3", "rub (100)", XMLCurrencyParser.getCurrency("643"));
//        response.getWriter().println(currencies);
//
//
//        PrintWriter out = response.getWriter();
//        out.println("<html><b>Currencies</b><html><table border// =\"0\" width=\"80%\"><tr><th>#</th><th>ID</th><th>Rate</th></tr><tr bgcolor='white'><td>1</td><td>USD</td><td>3.209</td></tr></table></html>\n<body>");
    }
}

// 1. таск конвертер из 1 валюты в другую

