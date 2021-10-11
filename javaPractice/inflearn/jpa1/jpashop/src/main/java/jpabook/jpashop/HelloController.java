package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Kim Jae Jun 님!!!");
        return "hello"; // 화면 이름. resoutces/template/${NAME}.html. spring boot thymeleaf 가 알아서 매핑을 하는 것이다.
    }
}
