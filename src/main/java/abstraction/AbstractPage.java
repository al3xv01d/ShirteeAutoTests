package abstraction;


public abstract class AbstractPage extends AbstractPageElement {

    public void open(String url) {
        driver.get(url);
    }



}
