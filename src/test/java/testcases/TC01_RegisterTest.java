package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

import java.time.Duration;
import java.util.UUID;

public class TC01_RegisterTest {

    @Test(description = "Register Test")
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage();

        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site
        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Step 1: Click link "Đăng Ký"
        By byBtnRegister = By.xpath("//h3[text()='Đăng Ký']");
        WebElement btnRegister = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRegister));
        btnRegister.click();

        //Step 2: Enter account
        String account = UUID.randomUUID().toString();
        registerPage.enterAccount(webDriverWait, account);

        //Step 3: Enter password
        registerPage.enterPassword(webDriverWait, "Test123456@");

        //Step 4: Enter confirm password
        registerPage.enterConfirmPassword(webDriverWait, "Test123456@");

        //Step 5: Enter name
        registerPage.enterName(webDriverWait, "John A");

        //Step 6: Enter email
        String email = account + "@example.com";
        registerPage.enterEmail(webDriverWait, email);

        //Step 7: Click register button
        registerPage.clickRegister(webDriverWait);

        //Step 8: Verify user register successfully
        //VP1: 'Đăng ký thành công' message display
        String actualRegisterMsg = registerPage.getRegisterMessage(webDriverWait);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register message failed!");

        //VP2: Check register page still displays
        String url = driver.getCurrentUrl();
        softAssert.assertEquals(url, "https://demo1.cybersoft.edu.vn/sign-up", "Register page does not display!");
        softAssert.assertAll(); // buoc nay moi kiem tra tong ket

        //VP3: Check new account logins successfully
        //Click on Login button
        By byBtnLoginLink = By.xpath("//h3[text()='Đăng Nhập']/parent::a");
        WebElement btnLogin = webDriverWait.until(ExpectedConditions.elementToBeClickable(byBtnLoginLink));
        btnLogin.click();

        //Enter account to login
        By byTxtAccountLogin = By.id("taiKhoan");
        WebElement txtAccountLogin = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccountLogin));
        txtAccountLogin.sendKeys(account);

        //Enter password to login
        By byTxtPasswordLogin = By.id("matKhau");
        WebElement txtPasswordLogin = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        txtPasswordLogin.sendKeys("Test123456@");

        //Click Login
        By byBtnLoginForm = By.xpath("//button[.='Đăng nhập']");
        WebElement btnLoginForm = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byBtnLoginForm));

        //cach 1:
        //Javascript ko phai nguoi binh thuong (bat loi: user click ko dc, loi cua ban, bypass bug)
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", btnLoginForm);

        //cach 2: xai submit()
        btnLoginForm.submit();

        //cach 3:
        //Ly do: ???
        //Thread.sleep(1000)
//        btnLoginForm.click();

        //VP3.1: 'Đăng nhập thành công' message displays
        By byLblLoginMsg = By.id("swal2-title");
        WebElement lblLoginMsg = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginMsg));
        String actualLoginMsg = lblLoginMsg.getText();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login message failed!");


        driver.quit(); // quit driver session (kiem tra se ko con chromedriver.exe)

    }
}
