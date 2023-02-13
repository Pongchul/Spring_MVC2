package hello.itemservice.domain.item;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
int가 아니라 Integer를 쓰는 이유
int를 쓰게 되면 price = 0 이라도 들어가야 하지만
Integer를 쓰면 Null이 들어갈 수 있다.
 */
@Data
public class Item {

    private Long id;
    private String itemname;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemname, Integer price, Integer quantity) {
        this.itemname = itemname;
        this.price = price;
        this.quantity = quantity;
    }
}
