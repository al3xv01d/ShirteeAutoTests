package abstraction;


import tools.Config;

public abstract class AbstractPage extends AbstractPageElement {

    protected String pageUrl = Config.indexShirteeUrl;

    public void openUrl(String url) {
        driver.get(url);
    }

    public void openSelf() {
        driver.get(pageUrl);
    }


}
