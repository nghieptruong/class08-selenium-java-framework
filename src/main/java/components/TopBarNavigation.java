package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBarNavigation {
    private By byBtnRegisterLink = By.xpath("//h3[text()='Đăng Ký']");
    private By byBtnLoginLink = By.xpath("//h3[text()='Đăng Nhập']/parent::a");

    public void navigateRegisterPage(WebDriverWait webDriverWait) {
        WebElement btnRegister = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRegisterLink));
        btnRegister.click();
    }

    public void navigateLoginPage(WebDriverWait webDriverWait) {
        WebElement btnLogin = webDriverWait.until(ExpectedConditions.elementToBeClickable(byBtnLoginLink));
        btnLogin.click();
    }
}
