package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;


public class RegisterPage extends CommonPage {

    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtName = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegisterNewAcc = By.xpath("//button[.='Đăng ký']");
    private By byLblRegisterMsg = By.id("swal2-title");

    public void enterAccount(String account) {
        sendKeys(DriverFactory.getDriver(), byTxtAccount, account);
    }

    public void enterPassword(String password) {
        sendKeys(DriverFactory.getDriver(), byTxtPassword, password);
    }

    public void enterConfirmPassword(String password) {
        sendKeys(DriverFactory.getDriver(), byTxtConfirmPassword, password);
    }

    public void enterName(String name) {
        sendKeys(DriverFactory.getDriver(), byTxtName, name);
    }

    public void enterEmail(String email) {
        sendKeys(DriverFactory.getDriver(), byTxtEmail, email);
    }

    public void clickRegister() {
        click(DriverFactory.getDriver(), byBtnRegisterNewAcc);
    }

    public String getRegisterMessage() {
        return getText(DriverFactory.getDriver(), byLblRegisterMsg);
    }

    public void waitRegisterMessageDisappear() {
        waitForInvisibilityOfElementLocated(DriverFactory.getDriver(), byLblRegisterMsg);
    }
}
