package com.vovamisjul;

import com.vovamisjul.Parsers.ParserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@WebServlet("/parse")
@MultipartConfig
public class ParseController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var filePart = req.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        req.setAttribute("parsedTable", ParserManager.parseXML(fileContent, req.getParameter("type")));
        var dispatcher = req.getRequestDispatcher("parsed.jsp");
        dispatcher.forward(req, resp);
    }
}
