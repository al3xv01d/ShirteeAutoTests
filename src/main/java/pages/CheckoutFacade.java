package pages;


import org.openqa.selenium.By;
import pages_elements.checkout.OrderedItem;

import java.util.ArrayList;
import java.util.List;

public class CheckoutFacade extends AbstractPage{

    private final String orderedItem_lo = "//div[@class=\"checkout-product\"]";

    private List<OrderedItem> allOrderedItems = new ArrayList<OrderedItem>();

    public List<OrderedItem> getAllOrderedItems() {
        System.out.println("fuck1111111");

        int itemsInCart = driver.findElements(By.xpath(this.orderedItem_lo)).size();
        System.out.println(itemsInCart);

        if(null == allOrderedItems || itemsInCart != allOrderedItems.size() ) {
            System.out.println("IFFFFF");
            for(int i=0; i < itemsInCart ;i++) {
                this.allOrderedItems.add(new OrderedItem(i+1));
                System.out.println("fuck");
            }
        }

        return allOrderedItems;
    }

}
