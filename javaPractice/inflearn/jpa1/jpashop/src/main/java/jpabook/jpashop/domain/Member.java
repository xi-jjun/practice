package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 하나의 회원이 여러개의 주문을 할 수 있기에 Member 와 Order 는 1:다 관계이다. 그리고 Order class에 FK가 있으므로 주인이 된다. 따라서 Member는 읽기전용
    private List<Order> orders = new ArrayList<>();
}
