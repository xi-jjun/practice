package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Json data 뿌리기
		// Content-Type : application/json
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8"); // <- 의미없는 파라미터 추가한 것이다.

		HelloData helloData = new HelloData();
		helloData.setUsername("kim");
		helloData.setAge(26);

		// {"username":"kim", "age":26} <- 이런식으로 바뀔 것이다.
		String result = objectMapper.writeValueAsString(helloData); // Object -> json 문자로 변경
		response.getWriter().write(result);
	}
}
