package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 구현체에 더 이상 의존을 안하게 됨. 이제 MemberRepository라는 추상에만 의존하게 됐다.

    @Autowired // Spring 이 알아서 MemberRepository type 을 찾아와서 자동으로 연결해서 주입.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
