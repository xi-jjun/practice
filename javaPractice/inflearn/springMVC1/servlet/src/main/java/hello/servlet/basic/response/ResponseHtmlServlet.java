package hello.servlet.basic.response;

import hello.servlet.basic.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HelloServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Content-Type : text/html, charset=utf-8
		response.setContentType("text/html"); // <- 지정해줘야 한다.
		response.setCharacterEncoding("utf-8");

		// servlet 으로 html rendering 하는 방법.
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println(" <div>안녕!</div>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
