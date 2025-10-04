package drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver; // đang null

    public abstract void createDriver();

    public WebDriver getDriver() {
        if(driver == null)
            createDriver();
        return this.driver;
    }

}
