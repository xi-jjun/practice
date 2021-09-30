package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memoryRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memoryRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memoryRepository.findById(memberId);
    }
}
