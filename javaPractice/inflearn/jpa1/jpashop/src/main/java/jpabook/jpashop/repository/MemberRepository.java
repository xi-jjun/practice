package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository // ComponentScan 에의해서 자동으로 Bean 등록 됨.
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member); // persist 만 한다고 해서 INSERT query 가 실행되는건 아니다.

    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // 단건 조회
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL , return type. SQL 이랑 JPQL 은 다르다. JPQL 은 Object 를 대상으로 query 날림. SQL 은 Table 을 대상으로 날림.
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
