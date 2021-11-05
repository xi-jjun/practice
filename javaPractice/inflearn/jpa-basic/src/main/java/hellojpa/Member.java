package hellojpa;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA 가 처음에 Loading 될 때 이걸 보고 Member 는 JPA를 사용하는 애구나! JPA가 관리해야겠다! 인식
// @Table(name = "NAME") query 가 나갈 때 DB의 이름 NAME으로 간다. DB table의 이름이 NAME인 경우 이렇게 한다.(Java class명과 다를 때)
// @Entity(name = "NAME") 같은 이름의 클래스가 있다면 써준다. JPA 가 내부적으로 구분하는 이름
@SequenceGenerator(
        name = "SEQ_GEN",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Getter
public class Member {

    @Id // PK 를 반드시 알려줘야만 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifyDate;

    public Member() {

    }

    public Member(String name) {
        this.username = name;
    }
}



