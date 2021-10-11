package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional // Test 에서 이 Annotation 이 있으면 Test 종료 후 DB 를 항상 RollBack 한다. //
    @Rollback(false) // 해당 Annotation 넣어주면 rollback 안한다.
    public void testMember() throws Exception {
        Member member = new Member();
        member.setUsername("userA");
        System.out.println("a");
        Long saveId = memberRepository.save(member);
        Member memberFinded = memberRepository.find(saveId);
        System.out.println("b");
        Assertions.assertThat(member.getId()).isEqualTo(memberFinded.getId());
        Assertions.assertThat(member.getUsername()).isEqualTo(memberFinded.getUsername());

        Assertions.assertThat(member).isEqualTo(memberFinded); // em.find 에서 find 의 명세를 보면
//      return value : the found entity instance 라고 되어있다. 따라서 instance 를 반환하는 것. instance == 이미 만들어져 있는 객체 라고 난 생각했다. 나중에 기본편 보고 맞는지 확인 예정.
    }
}