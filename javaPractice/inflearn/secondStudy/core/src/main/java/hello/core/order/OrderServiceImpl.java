package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // <-- 추상뿐만 아니라 구현체에게도 의존하게 된다.DIP위반
    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // <-- 추상뿐만 아니라 구현체에게도 의존하게 된다.DIP위반
    private final DiscountPolicy discountPolicy; // 구현체에게 의존 안하기 위해서 지워버림. interface에게만 의존하게 됐다.

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
