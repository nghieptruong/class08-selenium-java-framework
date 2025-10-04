package testcases;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;
import java.util.UUID;

public class TC01_RegisterTest extends BaseTest {

    @Test(description = "Register Test")
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site --> HomePage

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Step 1: Click link "Đăng Ký"
        homePage.getTopBarNavigation().navigateRegisterPage(webDriverWait);

        //Step 2: Enter account
        String account = UUID.randomUUID().toString();
        System.out.println("account = " + account);
        registerPage.enterAccount(account);

        //Step 3: Enter password
        registerPage.enterPassword("Test123456@");

        //Step 4: Enter confirm password
        registerPage.enterConfirmPassword("Test123456@");

        //Step 5: Enter name
        registerPage.enterName("John A");

        //Step 6: Enter email
        String email = account + "@example.com";
        registerPage.enterEmail(email);

        //Step 7: Click register button
        registerPage.clickRegister();

        //Step 8: Verify user register successfully
        //VP1: 'Đăng ký thành công' message display
        String actualRegisterMsg = registerPage.getRegisterMessage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register message failed!");

        registerPage.waitRegisterMessageDisappear();

        //VP2: Check register page still displays
        String url = driver.getCurrentUrl();
        softAssert.assertEquals(url, "https://demo1.cybersoft.edu.vn/sign-up", "Register page does not display!");
        softAssert.assertAll(); // buoc nay moi kiem tra tong ket

        //VP3: Check new account logins successfully
        //Click on Login button
        registerPage.getTopBarNavigation().navigateLoginPage(webDriverWait);

        //Enter account to login
        loginPage.enterAccount(account);

        //Enter password to login
        loginPage.enterPassword("Test123456@");

        //Click Login
        loginPage.clickLogin();

        //VP3.1: 'Đăng nhập thành công' message displays
        String actualLoginMsg = loginPage.getLoginMsg();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login message failed!");


        driver.quit(); // quit driver session (kiem tra se ko con chromedriver.exe)

    }
}
