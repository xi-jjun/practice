package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class); // 여기에 class 를 지정해주면, @Component 가 없어도 class 가 ComponentScan의 대상처럼 동작. Bean 에 바로 등록해버림.
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class); // Bean 을 조회하려는 지금!! Bean 생성 후 의존관계 주입 + 초기화 해줌.
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class); // 이 때 다시 Bean 생성.
        Assertions.assertThat(bean1).isNotSameAs(bean2); // spring container 가 반환해주고 이제 더 이상 해당 객체들에게 관여 x

        bean1.destroy(); // spring container 의 손을 떠났기 때문에 직접 client 가 종료시켜야 한다. (만약 필요하다면)
        ac.close(); // spring container 를 종료시켰지만 이미 prototype 에는 관여를 안하기 때문에 destroy 메서드는 수행이 안됨.
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.close");
        }
    }
}
