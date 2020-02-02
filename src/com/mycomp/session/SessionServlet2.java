package com.mycomp.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SessionServlet2 service...");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username = " + username);
    }

}
