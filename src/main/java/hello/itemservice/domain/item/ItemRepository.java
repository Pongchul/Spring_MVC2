package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository         // Component Scan의 대상이 된다. (스프링 빈)
public class ItemRepository {

    /**
     * Multithread에서 여러군데 Store을 접근하니까 원래는 싱글톤으로 생성되니 HashMap을 사용하면 안된다.
     * 동시에 여러 Thread가 접근하므로 HashMap 말고 ConcurrentHashMap을 생성해야한다.
     * Long 또한 동시에 접근할 수 있기 때문에 AutomicLong을 사용해야한다.
     */


    private static final Map<Long, Item> store = new HashMap<>();       // static
    private static Long sequence = 0L;              // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemname(updateParam.getItemname());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
}
