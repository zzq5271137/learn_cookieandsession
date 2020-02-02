package com.mycomp.last;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 小案例: 获取上次的访问时间
 */

@WebServlet("/LastServlet")
public class LastServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 获取当前的日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd/hh:mm:ss");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);

        // 2. 把日期写到cookie当中
        Cookie cookie = new Cookie("lasttime", dateStr);

        // 3. 响应给浏览器
        response.addCookie(cookie);

        // 获取cookie
        String lasttime = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lasttime")) {
                    lasttime = c.getValue();
                }
            }
        }

        response.setContentType("text/html;charset=utf-8");
        if (lasttime != null) {
            response.getWriter().write("<h1>上一次的登录时间为" + lasttime + "</h1>");
        } else {
            response.getWriter().write("<h1>你是第一次访问</h1>");
        }
    }

}
