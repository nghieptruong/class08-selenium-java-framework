package components;

import base.BasePage;
import drivers.DriverFactory;
import org.openqa.selenium.By;


public class TopBarNavigation extends BasePage {
    private By byBtnRegisterLink = By.xpath("//h3[text()='Đăng Ký']");
    private By byBtnLoginLink = By.xpath("//h3[text()='Đăng Nhập']/parent::a");

    public void navigateRegisterPage() {
        LOG.info("navigateRegisterPage");
        click(DriverFactory.getDriver(), byBtnRegisterLink);
    }

    public void navigateLoginPage() {
        LOG.info("navigateLoginPage");
        click(DriverFactory.getDriver(), byBtnLoginLink);
    }
}
