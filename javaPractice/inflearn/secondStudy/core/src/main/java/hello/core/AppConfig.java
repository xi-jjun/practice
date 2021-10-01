package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        // 현재 나의 App에서는 MemberServiceImpl을 쓸거야!
        return new MemberServiceImpl(memoryRepository()); // MemberServiceImpl에 생성자 만들어서 넣어준다. Constructor Injection
    }

    // method와 return type으로 역할이 한눈에 보인다
    private MemberRepository memoryRepository() {
        return new MemoryMemberRepository(); // 현재 이걸로 쓸 것. 나중에 바뀌면 여기만 수정하면 된다.
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy()); // Constructor Injection
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
