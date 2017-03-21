import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin_alex on 3/14/2017.
 */
public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void one() throws InterruptedException {
        LoginMethods login = new LoginMethods(driver);
        LoginVar var = new LoginVar();
// assert popUp subscribe
        Assert.assertTrue(login.findElement(var.presentPopUp).isDisplayed(),
                "No popUp mail notification");
// click closed button popUp
        login.pressButton(var.closePopUp);
// assert field войдите в личный кабинет
        Assert.assertTrue(login.findElement(var.voitiPrivatCabinet).isDisplayed(),
                "No popUp mail notification");
// click voiti
        login.pressButton(var.voitiPrivatCabinet);
        Thread.sleep(2000);
// assert popUp login & register
        //Assert.assertTrue(login.findElement(var.loginRegisterPopUp).isDisplayed(),
        //      "No popUp mail notification");
// 1-st negative press  Войти
        login.pressButton(var.vhodButton);
        Thread.sleep(3000);
        Assert.assertTrue(login.findElement(var.passwordUser).isDisplayed(),
                "ololo");
        Thread.sleep(3000);
        login.findElement(var.passwordUserWrong);
        Thread.sleep(3000);

    }
}
