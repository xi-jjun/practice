package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // /hello 로 오면 실행된다는 뜻
public class HelloServlet extends HttpServlet {

    @Override // servlet 이 호출되면 service method 가 호출된다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request.toString());
        System.out.println("response = " + response.toString());

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // content type <- HEADER 정보로 들어간다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //

        response.getWriter().write("hello " + username);
    }
}
