package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		log.info("username = {}, age = {}", username, age);

		response.getWriter().write("ok");
	}

	@ResponseBody // return 값이 view 가 아닌 html body 에 박아버린다
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
			@RequestParam("username") String username,
			@RequestParam("age") String age
	) {
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}

	@ResponseBody // return 값이 view 가 아닌 html body 에 박아버린다
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
			@RequestParam String username,
			@RequestParam String age
	) {
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}

	@ResponseBody // return 값이 view 가 아닌 html body 에 박아버린다
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, String age) {
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}
}
