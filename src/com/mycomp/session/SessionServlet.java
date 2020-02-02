package com.mycomp.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // session和cookie的区别:
        // cookie是存储在浏览器(客户端)的,它携带在请求头中发送给服务器
        // session是存储在服务器端的,它为每个客户端都创建一块内存空间存储该客户的信息
        // 客户端需要每次都携带一个标识ID(SessionID)去服务器中寻找自己的session内存空间
        // SessionID是服务器在创建session区域的时候创建的,并且会自动的把这个id写到浏览器里(以cookie的形式)
        // 下一次浏览器访问服务器,就会自动地携带SessionID,服务器端会通过它找响应的Session空间
        // (session也是一个域,参考ServletContext和RequestContext)

        // 获取专属于当前会话的Session对象
        // 如果服务器端没有该会话的Session对象,会创建一个新的Session并返回
        // 如果已经有了属于该会话的Session对象,就直接返回已有的对象
        // 本质就是根据SessionID来判断该客户端(浏览器)是否在服务器上已经存在Session了
        HttpSession session = request.getSession();

        // session过期时间默认是30分钟(在tomcat的全局web.xml中)
        // 可以在每个项目各自的web.xml中进行配置
        // <session-config>
        // <session-timeout>30</session-timeout>
        // </session-config>
        // 中间的数字代表分钟
        // 关闭浏览器时session就被销毁的说法是错误的

        // 也可以主动销毁session
        // session.invalidate();

        // 但是这有一个问题
        // 当你关闭浏览器再打开并访问相同工程时,是访问不到之前的session空间的
        // 这是因为当session首次创建时,会自动创建一个SessionID并自动发送给浏览器(以cookie的形式),用来以后访问该session空间
        // 但是cookie是会话级别的(参考cookie包中的CookieServlet)
        // 所以当你关闭浏览器再打开并访问相同工程时,浏览器是不会携带之前的SessionID的,自然也就访问不到之前的session空间
        // 事实上之前的session并没有销毁

        // 要解决这个问题,需要设置携带SessionID的cookie的持久化时间
        // 这里cookie的名字一定要是JSESSIONID
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        // 其中,session自动创建的cookie的path是整个工程的,我们也需要做这一步
        cookie.setPath("/Learn_CookieAndSession");
        cookie.setMaxAge(60 * 30); // 30分钟过期,和session默认的过期时间一样
        response.addCookie(cookie);

        session.setAttribute("username", "zzq");
    }

}
