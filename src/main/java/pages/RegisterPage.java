package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private By byTxtAccount = By.id("taiKhoan");
    private By byTxtPassword = By.id("matKhau");
    private By byTxtConfirmPassword = By.id("confirmPassWord");
    private By byTxtName = By.id("hoTen");
    private By byTxtEmail = By.id("email");
    private By byBtnRegisterNewAcc = By.xpath("//button[.='Đăng ký']");
    private By byLblRegisterMsg = By.id("swal2-title");

    public void enterAccount(WebDriverWait wait, String account) {
        WebElement txtAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccount));
        txtAccount.sendKeys(account);
    }

    public void enterPassword(WebDriverWait wait, String password) {
        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(WebDriverWait wait, String password) {
        WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        txtConfirmPassword.sendKeys(password);
    }

    public void enterName(WebDriverWait wait, String name) {
        WebElement txtName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtName));
        txtName.sendKeys(name);
    }

    public void enterEmail(WebDriverWait wait, String email) {
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        txtEmail.sendKeys(email);
    }

    public void clickRegister(WebDriverWait wait) {
        WebElement btnRegisterNewAcc = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegisterNewAcc));
        btnRegisterNewAcc.click();
    }

    public String getRegisterMessage(WebDriverWait wait) {
        WebElement lblRegisterMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblRegisterMsg));
        String actualRegisterMsg = lblRegisterMsg.getText();
        return actualRegisterMsg;
    }
}
