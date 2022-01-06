package hello.servlet.web.frontcontroller.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;

@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {
	private final Map<String, ControllerV3> controllerV3Mapper = new HashMap<>();

	public FrontControllerV3() {
		controllerV3Mapper.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerV3Mapper.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerV3Mapper.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FrontControllerV3.service");

		String requestURI = request.getRequestURI();

		ControllerV3 controller = controllerV3Mapper.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Map<String, String> paramMap = createParamMap(request);
		ModelView modelView = controller.process(paramMap); // 얘가 알려주는 것은 논리 이름. ex) new-form

		String viewName = modelView.getViewName(); // 논리 이름
		MyView view = viewResolver(viewName); // 물리 이름으로 바꿔서 myView 생성

		view.render(modelView.getModel(), request, response);
		// Model 도 같이 넘겨줘야 함. 원래 controller 에서 바로 request.setAttribute 했으나
		// 이제는 넘겨준 뒤, rendering 할 때 해준다.
	}

	private MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
