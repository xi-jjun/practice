package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class MappingController {
	@RequestMapping("/hello-basic")
	public String helloBasic() {
		log.info("hello basic");
		return "ok";
	}

	@GetMapping("/users/{userId}") // 이런식으로 path variable 를 매핑에 쓸 수 있다. URL 경로를 template 화 한것
	public String mappingPath(@PathVariable("userId") String data) { // @PathVariable 로 꺼내서 쓰는 것도 가능하다.
		log.info("userId : {}", data);
		return "ok";
	}
}
