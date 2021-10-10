package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
//    private final MyLogger myLogger; // 마찬가지로 현재 HTTP Request 가 없어서 의존관계 주입이 안된다.
//    private final ObjectProvider<MyLogger> myLoggerProvider; // @2 Provider 를 사용해서 의존관계를 주입해준다.
    private final MyLogger myLogger;

    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject(); // @2

        myLogger.log("service id = " + id);
    }
}
