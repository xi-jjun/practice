package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // return 값이 바로 http message body 로 들어간다.
// @Controller : return 값이 view 이름으로 인식된다.
public class LogTestController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/log-test")
	public String logTest() {
		String name = "spring";
		/**
		 * 2022-01-11 22:26:19.424  INFO 34001 --- [nio-8080-exec-1] hello.springmvc.basic.LogTestController  :  info name = spring
		 * 시간 INFO ProcessId --- [실행시킨 thread] class : 내용
		 */
		logger.info("info log = {}", name);

		// MY_LEVEL : trace > debug > info > warn > error
		/**
		 * application.properties
		 * logging.level.hello.springmvc=MY_LEVEL
		 * MY_LEVEL 단계인 만큼 정보가 보임.
		 * 개발 서버 MY_LEVEL=debug  : debug, info, warn, error
		 * 나의 로컬 MY_LEVEL=trace (모두 다 보겠다는 뜻)  : trace, debug, info, warn, error
		 * 운영 서버 MY_LEVEL=info (중요한 정보만 보겠다)  : info, warn, error
		 */
		logger.trace("trace log = {}", name);
		logger.debug("debug log = {}", name); // 개발서버에서 보는거
		logger.info("info log = {}", name); // 중요한 정보
		logger.warn("warn log = {}", name);
		logger.error("error log = {}", name);

		return "ok";
	}
}
