package testcases;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;


public class TC02_LoginTest extends BaseTest {

    @Test(description = "Login Test")
    public void testLogin() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site --> HomePage

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Step 1: Click 'Dang Nhap' link on the top right
        homePage.getTopBarNavigation().navigateLoginPage(webDriverWait);

        //Step 2: Enter account to login
        String account = "a68cf217-d33b-4132-b180-864697ac8427"; //exist account
        loginPage.enterAccount(account);

        //Step 3: Enter password to login
        loginPage.enterPassword("Test123456@");

        //Step 4: Click Login
        loginPage.clickLogin();

        //VP1: 'Đăng nhập thành công' message displays
        String actualLoginMsg = loginPage.getLoginMsg();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login message failed!");

        //VP2: Check 'Dang Xuat' button link displays on the top right
        //VP3: Check user profile name displays

        driver.quit();
    }
}
