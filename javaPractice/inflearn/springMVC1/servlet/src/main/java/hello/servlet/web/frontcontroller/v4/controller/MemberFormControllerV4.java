package hello.servlet.web.frontcontroller.v4.controller;

import java.util.Map;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberFormControllerV4 implements ControllerV4 {
	@Override // FrontController 에서 model 이랑 paramMap 만들어줄 것이다.
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "new-form";
	}
}
