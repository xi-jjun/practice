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
//        try {
//            Member findMember = em.find(Member.class, 1L); // 찾으려는 Class , PK
//            findMember.setName("Changed Name"); // Java 객체에서 값만 바꿔도 DB에 update 되는 GOD JPA
//            /***
//             * 원리
//             * em.find(JPA 를 통해) 해서 가져오는 시점에 JPA가 해당 객체를 관리하게 된다.
//             * JPA 가 변경이 됐는지 tx.commit 시점에 모두 확인을 한다.
//             * 수정사항이 있으면 Update query 만들어서 날린다.
//             */
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close(); // 반드시 종료해줘야만 한다.
//        }


//        try {
//            // new == 비영속 상태. member 라는 객체가 생성만 됐을 뿐 현재 JPA와는 아무 관련이 없다.
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("UserB");
//
//            // 영속 상태 - DB에 저장된 것 아님.
//            em.persist(member); // 이 코드일 때 Query 가 날라가지 않는다.
//
////            em.detach(member); // member 를 다시 영속성 컨텍스트에서 지운다.
////            em.remove(member); // 실제 DB에서 지운다.
//
//            tx.commit(); // 이 시점에 영속성에 있는 객체의 Query를 날린다.
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close(); // 반드시 종료해줘야만 한다.
//        }


        try {
            Member member = new Member("김재준");
            Board board = new Board("title!!!", "conteeeeeeeeent!!");
            System.out.println("===========");
            System.out.println("member = " + member.getId());
            em.persist(member); // tx.commit 전까지는 query 를 미리 볼 수 없다.
            System.out.println("member = " + member.getId());
            em.persist(board);
            System.out.println("===========");
            em.flush(); // 이 때 DB 에 영속성 컨텍스트의 변경내용이 반영이 된다.

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 반드시 종료해줘야만 한다.
        }

        emf.close();
    }
}
