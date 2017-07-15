package pages_elements.dashboard_orders;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.PriceHelper;

public class Order extends AbstractPageElement{


    //*******************  LOCATORS ********************//

    private String orderLine_lo = ".//*[@id='userhistory']//tbody/tr[%d]";

    private String orderId_lo = "./td[1]//span";
    private String orderItemsQty_lo = "./td[4]";
    private String orderTotalPrice_lo = "./td[5]//span";

    //*******************  WEBDRIVER ELEMENTS ********************//

    private WebElement orderLine;

    //*******************  ACTIONS ********************//

    public Order(int orderNumber) {
        this.orderLine = driver.findElement(By.xpath(String.format(orderLine_lo, orderNumber)));
    }

    public String getOrderId() {
        return orderLine.findElement(By.xpath(orderId_lo)).getText().substring(7); // get only ID without "Order" and "#"
    }

    public double getItemsQty() {
        return Double.parseDouble( orderLine.findElement(By.xpath(orderItemsQty_lo)).getText() );
    }

    public double getTotalPrice() {
        return PriceHelper.getRealPrice( orderLine.findElement(By.xpath(orderTotalPrice_lo)).getText() );
    }


}
