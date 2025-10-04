package base;

import drivers.DriverFactory;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        DriverFactory.setDriver(driver);
    }

    @AfterClass
    public void afterClass() {
        if(driver != null)
            driver.quit();
    }

}
