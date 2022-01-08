package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
		ControllerV4 controller = (ControllerV4) handler;

		Map<String, String> paramMap = createParamMap(request); // <- getParameter(String name) 으로 "username" : Kim 이런거 Map 으로 저장.
		Map<String, Object> model = new HashMap<>();

		model.values().stream().forEach(v -> System.out.println(v.toString()));
		System.out.println("======after======");
		String viewName = controller.process(paramMap, model); // 논리 이름만 반환한다. ModelView return 해야하는데;;
		// 여기서 model 이 controller 구현체에서 추가된다. ex) save : model.put("member", member);
		model.values().stream().forEach(v -> System.out.println(v.toString()));

		// adapter 가 이름을 받아서 ModelView 로 변환 해주는 역할도 한 것.
		ModelView mv = new ModelView(viewName); // adapter 니깐 그에 맞게 ModelView 로 반환하게 바꿔준다.
		mv.setModel(model);

		return mv;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

		return paramMap;
	}
}
