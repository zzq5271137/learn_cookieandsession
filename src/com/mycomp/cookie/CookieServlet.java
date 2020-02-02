package com.mycomp.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/zzq/CookieServlet")
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 创建cookie
        Cookie cookie = new Cookie("username", "zzq");

        // cookie的默认存储时间:
        // 默认,cookie是会话级别的(打开浏览器到下一次关闭浏览器为一次会话)
        // 如果不设置持久化时间,cookie是存储在浏览器的内存中的,当浏览器关闭,cookie信息就会被销毁
        // 可以主动去设置cookie在客户端的存储时间(使用setMaxAge()方法)
        // 以这种方式,cookie就不是存储在浏览器的内存中了,而是存储在浏览器的磁盘文件里
        // 如果过期就会自动删除
        cookie.setMaxAge(60);

        // 当cookie响应给浏览器之后,默认情况下,浏览器下一次访问服务器会自动携带此cookie
        // 默认情况下会在访问创建cookie的web资源相同的路径都携带cookie信息
        // 例如:
        // 创建cookie: ”http://localhost:8080/Learn_CookieAndSession/CookieServlet“
        // 此时,“http://localhost:8080/Learn_CookieAndSession/DeleteCookieServlet”就可以访问到
        // 因为,他们两个servlet的web资源的路径都是http://localhost:8080/Learn_CookieAndSession
        // 但如果修改了当前创建cookie的servlet名称("/CookieServlet"改为"/zzq/CookieServlet")
        // “http://localhost:8080/Learn_CookieAndSession/DeleteCookieServlet”就访问不到了
        // (web资源是指你当前servlet的url-pattern,web资源的路径就是url-pattern前面的东西)

        // 可以去主动设置cookie的携带路径(使用setPath()方法)
        // 有三种传参方式:
        // 1). cookie.setPath("/Project/servletUrl"), 只有访问指定servlet才携带
        // 2). cookie.setPath("/Project"), 访问指定工程时,都会携带
        // 3). cookie.setPath("/"), 访问服务器下所有的工程时都会携带
        cookie.setPath("/Learn_CookieAndSession");

        // 2. 响应给浏览器
        response.addCookie(cookie);
    }
}
