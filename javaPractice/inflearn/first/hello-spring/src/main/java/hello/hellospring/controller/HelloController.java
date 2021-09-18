package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello 로 오면 해당 method call
    public String hello(Model model) {
        model.addAttribute("data","HELLO!");
        return "hello"; // hello 라는 template rendering
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http body에 해당 부분을 직접 주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello"+name; // template이 아닌 이것 그대로 날라간다.
    }

    @GetMapping("hello-api")
    @ResponseBody // default : return json type
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hi = new Hello();
        hi.setName("Spring");
        return hi;
    }

    static class Hello{
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
