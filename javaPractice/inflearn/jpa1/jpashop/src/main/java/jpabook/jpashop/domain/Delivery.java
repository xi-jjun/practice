package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY) // Order class 에 있는 주인의 변수 이름을 적어준다.
    private Order order;

    @Embedded // 내장 타입이기 때문에 이걸 써줘야 함
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL은 절대 쓰지 말 것.
    private DeliveryStatus status; // READY, COMP
}
