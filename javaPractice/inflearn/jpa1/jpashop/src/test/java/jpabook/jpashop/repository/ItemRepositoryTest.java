package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ItemRepositoryTest {
    @Autowired private EntityManager em;
    @Autowired private ItemRepository itemRepository;

    @Test
    void 상품등록() {
        // given : 이런게 주어졌을 때
        Item item = new Book();
        item.setName("Hello JAVA!");

        itemRepository.save(item);

        assertEquals(item, itemRepository.findOne(item.getId()));
    }

}