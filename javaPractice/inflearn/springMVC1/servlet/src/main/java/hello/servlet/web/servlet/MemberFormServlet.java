package hello.servlet.web.servlet;

import hello.servlet.basic.HelloServlet;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HelloServlet {
	protected MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter writer = response.getWriter();
		// servlet 으로 하면 불편한 점이 한눈에 보인다... Java 코드로 html 을 다 적어줘야 하는게 정신 나감.
		writer.write("<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				" <meta charset=\"UTF-8\">\n" +
				" <title>Title</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"<form action=\"/servlet/members/save\" method=\"post\">\n" +
				" username: <input type=\"text\" name=\"username\" />\n" +
				" age: <input type=\"text\" name=\"age\" />\n" +
				" <button type=\"submit\">전송</button>\n" +
				"</form>\n" +
				"</body>\n" +
				"</html>\n");
	}
}
