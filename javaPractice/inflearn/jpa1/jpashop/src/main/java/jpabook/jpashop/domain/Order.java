package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    // 무조건 LAZY 로!
    @ManyToOne(fetch = FetchType.LAZY) // Order 와 Member 는 다:1 관계
    @JoinColumn(name = "member_id") // mapping 을 'member_id' 로 하겠다는 뜻. FK 의 이름이 'member_id' 가 된다.
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    private OrderStatus status; // Enum 주문 상태 [ORDER, CANCEL]

    //==연관 관계 method==// 양 방향 세팅
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this); // data type==Orders. 따라서 this 가 맞다.
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
