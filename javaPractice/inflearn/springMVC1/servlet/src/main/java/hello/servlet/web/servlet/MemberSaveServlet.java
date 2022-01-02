package hello.servlet.web.servlet;

import hello.servlet.basic.HelloServlet;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HelloServlet {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); // 이 방법으로 FormData 읽을 수 있다.
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		// html rendering...
		// header setting
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		// rendering
		PrintWriter writer = response.getWriter();
		writer.write("<html>\n" +
				"<head>\n" +
				" <meta charset=\"UTF-8\">\n" +
				"</head>\n" +
				"<body>\n" +
				"성공\n" +
				"<ul>\n" +
				" <li>id=" + member.getId() + "</li>\n" +
				" <li>username=" + member.getUsername() + "</li>\n" +
				" <li>age=" + member.getAge() + "</li>\n" +
				"</ul>\n" +
				"<a href=\"/index.html\">메인</a>\n" +
				"</body>\n" +
				"</html>");
	}
}
