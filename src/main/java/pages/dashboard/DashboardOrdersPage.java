package pages.dashboard;


import abstraction.AbstractPage;
import pages_elements.dashboard_orders.Order;
import tools.Config;

import java.util.List;

public class DashboardOrdersPage extends AbstractPage{

    private String lastOrder_lo = "";

    public void openPage() {
        driver.get(Config.dashboardOrdersPage);
    }

    public Order getLastOrder() {
        return new Order(1);
    }

//
//    public List<Order> getAllOrders() {
//
//        allAddedProducts.clear();
//
//        int size =  driver.findElements(By.xpath(".//*[@id='calculation-items']/tr")).size() / 2;
//        System.out.println("SIZE = " + size);
//        int n;
//
//        for (int i = 1; i <= size; i++ ) {
//
//            n = i*2 - 1;
//            //System.out.println(n);
//
//            allAddedProducts.add(new StepTwoAddedProduct(n));
//        }
//
//        return allAddedProducts;
//    }
}
