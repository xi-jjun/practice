package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class); // 둘 다 자동 Bean 등록된다.
        //  여기서 PrototypeBean class 를 Bean 등록 안하면, ClientBean 에 있는 Autowired 가 동작을 못 한다. -> 등록된 Bean에 해당 Bean 이 없기 때문이다.

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int logic1 = clientBean1.logic();

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int logic2 = clientBean2.logic();

        Assertions.assertThat(logic1).isEqualTo(1);
        Assertions.assertThat(logic2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {
//        private final PrototypeBean prototypeBean; // @1 ClientBean 이 호출된 시점에 생성됨. 그리고 ClientBean 는 Singleton 이라서 생성자 주입될 일이 없음.
        // 따라서 주입이 단 한번만 일어나므로 prototypeBean 은 1개만 생성된다.
        // 우리가 원하는건 우리가 쓸 때 마다 새로 생성되는 것. prototype 의 역할을 못하고 있다.

//        @Autowired private ApplicationContext ac; // @2 무식하게 logic 에서 호출 때 마다 Prototype Bean 생성되게 만듦.

//        @Autowired // @1
//        public ClientBean(PrototypeBean prototypeBean) {
//            this.prototypeBean = prototypeBean;
//        }

//        @Autowired // @3 지금은 Test 라서 field injection 한 것. 생성자 주입을 써라.
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        @Autowired // @4 지금은 Test 라서 field injection 한 것. 생성자 주입을 써라.
        private Provider<PrototypeBean> prototypeBeanProvider;

        // @4 logic Javax provider 에 의한 DL(Dependency Lookup)
        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
//
//        // @3 logic provider 에 의한 DL(Dependency Lookup)
//        public int logic(){
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
//            prototypeBean.addCount();
//            return prototypeBean.getCount();
//        }

//        // @1 logic
//        public int logic(){
//            this.prototypeBean.addCount();
//            return this.prototypeBean.getCount();
//        }

        // @2 logic 이런식으로 무식하게
//        public int logic(){
//            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class); // logic 호출되면 prototype Bean 생성.
//            prototypeBean.addCount(); // 해당 Bean 에서 method 호출
//            return prototypeBean.getCount(); // 방금 logic 에서 호출된 Bean 의 method 값 반환
//        }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
