package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Enumerated(EnumType.STRING)
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


    //==생성 메서드==// <- 주문이라는 것 하나를 생성할 때 호출됨.
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //==비지니스 로직==//
    /**
     * CANCEL
     */
    public void cancel() {
        if(delivery.getStatus() == DeliveryStatus.COMP) { // 주문을 취소하려 하는데 이미 배송을 해버린 경우
            throw new IllegalStateException("이미 배송 완료된 상품은 취소가 불가능 합니다");
        }
        this.setStatus(OrderStatus.CANCEL); // 위의 exception 통과하면 배송 전 이므로 취소해준다.
        for (OrderItem orderItem : this.orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//

    /**
     * 전체 주문 가격 조회
     * @return 주문한 총 비용
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
//            totalPrice += orderItem.getOrderPrice(); // 주문수량 x 주문가격 을 해야 총 가격이 나오는데 얘는 무조건 주문수량이 1개인 경우만을 생각하기에
            totalPrice += orderItem.getTotalPrice(); // 이렇게 orderItem 에 method 하나를 더 만들어줬다.
        }
        return totalPrice;
    }
}
