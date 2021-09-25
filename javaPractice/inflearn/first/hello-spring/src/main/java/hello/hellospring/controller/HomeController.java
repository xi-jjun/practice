package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Spring Controller먼저 mapping됐는지 확인하고 없으면 static/hello-spring 으로 가는 것. 현재 이렇게 mapping돼있으니 바로 template/home.html 가져옴.
    @GetMapping("/") // 회원 등록을 하기위한 HTML 보여주는 곳
    public String home() {
        return "home";
    }
}
