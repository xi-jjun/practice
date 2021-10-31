package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA 가 처음에 Loading 될 때 이걸 보고 Member 는 JPA를 사용하는 애구나! JPA가 관리해야겠다! 인식
// @Table(name = "NAME") query 가 나갈 때 DB의 이름 NAME으로 간다. DB table의 이름이 NAME인 경우 이렇게 한다.(Java class명과 다를 때)
public class Member {

    @Id // PK 를 반드시 알려줘야만 한다.
    private Long id;
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
