package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // final keyword 로 된 field 에 생성자 자동으로 만들어서 주입
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final MyLogger myLogger; // HTTP 요청이 들어올 때 주입이 되는데 현재 spring 을 실행 할 때 그런 요청이 없다. 따라서 오류가 난다.
//    private final ObjectProvider<MyLogger> myLoggerProvider; // @2 따라서 이전에 배웠던 Provider 를 사용하여 DL 해준다.
    private final MyLogger myLogger; // Proxy

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
//        MyLogger myLogger = myLoggerProvider.getObject(); // @2 Spring Bean 에서 myLogger 를 찾아서 가져온다.

        // 가짜 MyLogger 이다.
        // CGLIB 이라는 라이브러리로 내 class 를 상속받은 가짜 Proxy 객체를 만들어서 주입하는 것.
        System.out.println("myLogger = " + myLogger.getClass()); // @Scope(r , Scoped..Proxy) spring에서 가짜로 클래스 하나 만들어준다.

        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL); // 실제 method 호출 될 때 진짜를 찾아서 동작한다.

        myLogger.log("Controller Test");
        logDemoService.logic("testId");
        return "OK";
    }
}
