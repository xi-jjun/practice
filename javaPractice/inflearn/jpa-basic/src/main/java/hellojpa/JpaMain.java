package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // "hello"==unit name. 로딩 시점에 딱 1개만 만들어놔야 한다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // JPA에서 모든 data의 수정은 transaction 안에서 발생해야 한다.
        tx.begin();

        // CREATE
//        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("UserB");
//            em.persist(member);
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }

        // FIND
//        try {
//            Member findMember = em.find(Member.class, 1L); // 찾으려는 Class , PK
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close(); // 반드시 종료해줘야만 한다.
//        }

        // UPDATE
        try {
            Member findMember = em.find(Member.class, 1L); // 찾으려는 Class , PK
            findMember.setName("Changed Name"); // Java 객체에서 값만 바꿔도 DB에 update 되는 GOD JPA
            /***
             * 원리
             * em.find(JPA 를 통해) 해서 가져오는 시점에 JPA가 해당 객체를 관리하게 된다.
             * JPA 가 변경이 됐는지 tx.commit 시점에 모두 확인을 한다.
             * 수정사항이 있으면 Update query 만들어서 날린다.
             */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 반드시 종료해줘야만 한다.
        }

        emf.close();
    }
}
