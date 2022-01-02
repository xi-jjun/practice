package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
	private ObjectMapper objectMapper = new ObjectMapper(); // Json 으로 변환하기 위해 Jackson 이라는 라이브러리 제공.

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = request.getInputStream();
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		System.out.println("messageBody = " + messageBody);

		// 우리가 만든 HelloData 라는 객체에 Json 정보를 담아준다.
		// postman 으로 post 요청 보내서 확인함.
		HelloData helloData = objectMapper.readValue(messageBody, HelloData.class); // mapping
		System.out.println(helloData.getUsername());
		System.out.println(helloData.getAge());
	}
}
