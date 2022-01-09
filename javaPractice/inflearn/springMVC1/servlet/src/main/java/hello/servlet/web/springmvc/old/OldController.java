package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// spring bean 의 이름을 설정한 것. url 에 spring bean 이름을 입력하면 그와 똑같은 spring bean 을 찾아서 실행해준다.
@Component("/springmvc/old-controller")
public class OldController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OldController.handleRequest");
		return new ModelAndView("new-form");
		/**
		 * new-form 이라는 논리적 이름을 연결하기 위해서 application.property 에서
		 * spring.mvc.view.prefix=/WEB-INF/views/
		 * spring.mvc.view.suffix=.jsp
		 * 를 추가해줘야 한다.
		 */
	}
}
