package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("spring없는 순수한 DI Container의 문제점")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

//        System.out.println("memberService1 = " + memberService1);
//        System.out.println("memberService2 = " + memberService2);

        // Test는 항상 자동화를 해야한다. 위에 코드처럼 System.out.print 써서 눈으로 보는건 안된다
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void singletonTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        SingletonService.getInstance().logic();
        Assertions.assertThat(singletonService1).isEqualTo(singletonService2);
    }

    @Test
    @DisplayName("Spring Container with Singleton")
    void container() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService bean1 = ac.getBean(MemberService.class);
        MemberService bean2 = ac.getBean(MemberService.class);

        Assertions.assertThat(bean1).isEqualTo(bean2);
    }

    @Test
    @DisplayName("memberRepository가 2번 호출된건가...?")
    void checkDup() {
        AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberRepository bean1 = ac.getBean(MemberRepository.class);
        MemberRepository bean2 = ac.getBean(MemberRepository.class);

        Assertions.assertThat(bean1).isEqualTo(bean2);
    }
}
