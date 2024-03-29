package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

//    @Column(name = "ORDER_ID")
//    private Long orderId;

    @ManyToOne @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne @JoinColumn(name = "ITEM_ID")
    private Item item;

//    @Column(name = "ITEM_ID")
//    private Long itemId;

    private int orderPrice;
    private int count;
}
