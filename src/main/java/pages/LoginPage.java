package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends CommonPage {

    private By byTxtAccountLogin = By.id("taiKhoan");
    private By byTxtPasswordLogin = By.id("matKhau");
    private By byBtnLoginForm = By.xpath("//button[.='Đăng nhập']");
    private By byLblLoginMsg = By.id("swal2-title");

    public void enterAccount(String account) {
        sendKeys(DriverFactory.getDriver(), byTxtAccountLogin, account);
    }

    public void enterPassword(String password) {
        sendKeys(DriverFactory.getDriver(), byTxtPasswordLogin, password);
    }

    public void clickLogin() {
        click(DriverFactory.getDriver(), byBtnLoginForm);
    }

    public String getLoginMsg() {
        return getText(DriverFactory.getDriver(), byLblLoginMsg);
    }
}
