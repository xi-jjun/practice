package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 구현체에 더 이상 의존을 안하게 됨. 이제 MemberRepository라는 추상에만 의존하게 됐다.

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
