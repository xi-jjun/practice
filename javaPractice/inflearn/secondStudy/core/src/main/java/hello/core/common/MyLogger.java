package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/***
 * Log 를 출력하기 위한 MyLogger class
 * @Scope(request) 로 HTTP 요청이 들어올 때 생성되고 끝나면 소멸.
 * Spring container 에게 요청 할 때 생성이 되는 class 이다.
 */
@Component
//@Scope("request")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + " [" + requestURL + "]" + " " + message);
    }

    @PostConstruct // Bean 이 생성되는 시점에 PostConstruct Annotaion 이 자동으로 초기화를 해준다.
    public void init() {
        uuid = UUID.randomUUID().toString(); // 절대로 겹치지 않는 유일한 ID 생성.
        System.out.println("[" + uuid + "] request scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean closed: " + this);
    }
}
