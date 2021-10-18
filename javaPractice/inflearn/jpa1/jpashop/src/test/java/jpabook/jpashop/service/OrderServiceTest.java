package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void 상품주문() {
        // given
        Member member = createMember("member1", "Seoul", "Wall", "113-13");

        Item item = createBook("JPA", 10000, 10);

        // when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "상품 주문시 상태는 ORDER");
        assertEquals(1, getOrder.getOrderItems().size(), "주문한 상품 종류의 개수가 맞아야 함");
        assertEquals(10000 * orderCount, getOrder.getTotalPrice(), "총 가격 = 상품가격 x 주문한 개수");
        assertEquals(8, item.getStockQuantity(), "주문 수량만큼 재고가 줄어야 한다");
//        Assertions.assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
    }

    @Test
    void 주문취소() {
        Member member = createMember("member1", "Seoul", "Wall", "113-13");
        Item book = createBook("JPA ORM", 43000, 10);

        int orderCount = 2;

        Long order = orderService.order(member.getId(), book.getId(), orderCount);
        // when
        orderService.cancelOrder(order);

        // then
        Order getOrder = orderRepository.findOne(order);
        Assertions.assertThat(10).isEqualTo(book.getStockQuantity());
        Assertions.assertThat(OrderStatus.CANCEL).isEqualTo(getOrder.getStatus());
    }

    @Test
    void 재고수량초과() throws Exception {
        Member member = createMember("member1", "Seoul", "Wall", "113-13");
        Item book = createBook("JPA ORM", 43000, 10);

        int orderCount = 11; // more than 10...

        // when
        assertThrows(NotEnoughStockException.class,
                () -> orderService.order(member.getId(), book.getId(), orderCount));

    }

    private Item createBook(String name, int price, int stockQuantity) {
        Item item = new Book();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        em.persist(item);
        return item;
    }

    private Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(new Address(city, street, zipcode));
        em.persist(member);
        return member;
    }
}