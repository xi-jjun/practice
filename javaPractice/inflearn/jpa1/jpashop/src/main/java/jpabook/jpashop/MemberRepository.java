package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // spring-boot-starter-jpa 이 자동으로 주입해준다.

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 왜 굳이 id 반환?? => command 와 query 를 분리해라. side effect 일으키는 command 이기 때문에 id 값 정도만 받아두는 것.
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
