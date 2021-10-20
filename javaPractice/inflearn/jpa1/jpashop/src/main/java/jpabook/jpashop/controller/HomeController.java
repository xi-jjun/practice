package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // Logger log = LoggerFactory.getLogger(getClass());
public class HomeController {

    @RequestMapping("/")
    public String home() {
        log.info("home control"); // 2021-10-20 15:11:50.699  INFO 24965 --- [nio-8080-exec-1] j.jpashop.controller.HomeController      : home control
        return "home";
    }
}
