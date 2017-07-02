package pages_elements.admin;


import abstraction.AbstractPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.PriceHelper;

public class OrderLine extends AbstractPageElement {

    private final String orderLine_lo = "//table[@id=\"sales_order_grid_table\"]/tbody/tr[1]";

    private final String orderId_lo = "./td[2]";

    private final String orderBasePrice_lo = "./td[7]";

    @FindBy(xpath = orderLine_lo)
    private WebElement orderLine;

    public String getOrderId() {
        return orderLine.findElement(By.xpath(orderId_lo)).getText();
    }

    public double getRealOrderPrice() {
        return PriceHelper.getRealPrice( orderLine.findElement(By.xpath(orderBasePrice_lo)).getText() );
    }

}
