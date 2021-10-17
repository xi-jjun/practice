package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
// ItemRepository 를 위임만 하는 class 이다. 따라서 이렇게 써야할지 고민을 해봐야 한다.
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    // item 을 저장하려면 "write" 를 해야함. 근데 위에 'readonly'로 돼있어서 저장 불가능. 따라서 @Transactional 이라는 Annotation 을 붙여준다.(기본값 write)
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // @Transactional 이 없이 때문에 맨 위의 readonly 가 된다.
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
