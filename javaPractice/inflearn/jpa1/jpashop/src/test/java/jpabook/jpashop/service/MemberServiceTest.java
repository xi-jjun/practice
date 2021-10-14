package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class) // Junit 4 로 Test 할건데 Spring 이랑 같이 실행할래!. junit 5 는 없어도 잘 됨
@SpringBootTest // spring boot 를 띄운 상태로 Test 진행하게 해줌. 의존관계 주입(Autowired) 를 해주는 역할이 있다.
@Transactional // Test code 에서만 roll back. 나머지 repository 나 다른 곳에선 안한다.
class MemberServiceTest {

    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;
    @Autowired private EntityManager em; // @1 roll back 이 되더라도 INSERT query 보고 싶다면,

    @Test
//    @Rollback(false) // @2 INSERT query 보고싶고, roll back 도 안하고 싶다면 해당 annotation 을 사용.
    public void 회원가입() throws Exception {
        // given : 이런게 주어졌을 때
        Member member = new Member();
        member.setName("rlawowns97");

        // when : 이렇게 하면
//        memberRepository.save(member); // 저장소는 '저장'의 기능만을 제공할 뿐. 직접 등장하지는 않아야 함.
        Long savedId = memberService.join(member);// 저장이라는 '행위'는 MemverService 에서 해준다. 이와 같이 Member에 관한 서비스는 해당 class 에서 제공.
// MemberRepository 는 단지 memberService 가 서비스를 제공하기 위해서 필요한 class 이다.

        // then : 이렇게 된다. 라는 것을 검증해보자!!
        em.flush(); // @1 flush 를 하면 DB 에 query 를 날리게 된다. springTest 에서는 @Transcational 이 항상 roll back 하기 때문에 굳이? INSERT 문을 날리지 않았던 것이다.
        assertEquals(member, memberRepository.findOne(savedId));
//        Assertions.assertThat(member.getName()).isEqualTo("rlawowns97");
    }

    @Test
//    @Test(expected = IllegalStateException.class) // @3. junit 4 에서는 가능. 5는 불가능. 현재 이 Test class==5
    public void 중복_회원가입() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("SAME_NAME");

        Member member2 = new Member();
        member2.setName("SAME_NAME");

        // when // junit 5 style  https://junit.org/junit5/docs/current/user-guide/ 참고. 강의랑 다름
        memberService.join(member1);
        Exception exception = assertThrows(IllegalStateException.class, ()->
                memberService.join(member2));

//        // when
//        memberService.join(member1);
//        // @3. 코드가 너무 긴 것 같다??
////        try {
////            memberService.join(member2); // Exception !!. join 함수는 예외를 밖으로 보낸다. 따라서 해당 코드에서 예외가 나오게 된다.
////                                        // 2. 그러나 밑에 fail() 을 추가해도 여기서 예외가 터져서 '중복_회원가입' 함수 밖으로 나가게돼서 테스트 실패.
////        } catch (IllegalStateException e) {return;}
//
//
//        // then
//        fail(); // 1. 여기까지 실행이 된다면 테스트 실패.
////        Assertions.assertThat(memberService.join(member2)).isEqualTo(new IllegalStateException("이미 존재하는 회원입니다"));
    }

}