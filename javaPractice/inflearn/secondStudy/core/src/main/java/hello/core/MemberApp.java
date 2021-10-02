package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(); // 구현에 의존하면 안된다. 제어는 AppConfig 가 하도록 했다.
        // 아래 2줄은 OCP, DIP 지키기 위해 AppConfig라는 관리자를 만들기 위한 것.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 이제 순수 JAVA말고 Spring을 사용. Spring container에서 bean을 가져옴.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member : " + member.getName());
        System.out.println("find member : " + findMember.getName());
    }
}
