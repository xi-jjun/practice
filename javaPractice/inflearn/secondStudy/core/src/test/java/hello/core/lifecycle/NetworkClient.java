package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient { //implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect(); // 생성자에서 호출하면 setter 에서 하기 전에 호출돼서 null값이 나온다. == 연결 안됐다는 뜻
//        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message=" + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("Closed: " + url);
    }

    @PostConstruct
    public void init() { // 의존관계 주입이 끝나면 호출해주겠다 라는 뜻
        connect(); // 여기서 의존관계 주입이 끝난 후 호출하게 하기 위함.
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() { // Bean 이 종료될 때 호출됨.
        disconnect();
    }
//    @Override
//    public void afterPropertiesSet() throws Exception { // 의존관계 주입이 끝나면 호출해주겠다 라는 뜻
//        connect(); // 여기서 의존관계 주입이 끝난 후 호출하게 하기 위함.
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception { // Bean 이 종료될 때 호출됨.
//        disconnect();
//    }
}
