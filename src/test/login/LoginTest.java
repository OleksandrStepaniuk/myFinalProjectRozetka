import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleksandr Stepaniuk on 3/14/2017.
 */
public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://erpsystem.jaya-test.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void headerTest() throws InterruptedException {
        LoginMethods login = new LoginMethods(driver);
        LoginVar var = new LoginVar();

        login.pressButton(LoginVar.signIn);
        login.sendK("ostepaniuk@jayadigital.com", LoginVar.emailSignin);
        login.sendK("Fkbyf1107", LoginVar.passwordSignin);
        login.pressButton(LoginVar.login);
        //header menu assert
        Assert.assertEquals("Messaging", login.assertText(LoginVar.header1));
        Assert.assertEquals("Project", login.assertText(LoginVar.header2));
        Assert.assertEquals("Marketing", login.assertText(LoginVar.header3));
        Assert.assertEquals("Human Resources", login.assertText(LoginVar.header4));
        Assert.assertEquals("Knowledge", login.assertText(LoginVar.header5));
        Assert.assertEquals("Reporting", login.assertText(LoginVar.header6));
        Assert.assertEquals("Website", login.assertText(LoginVar.header7));
        //Thread.sleep(5000);
        Assert.assertTrue(login.clickWhenReady((LoginVar.goToSystemButton), 1).isDisplayed(),
                "Not dispalyed button loginSystem");
        Assert.assertTrue(login.clickWhenReady((LoginVar.messagingInstant), 1).isDisplayed(),
                "Not dispalyed button message");

    }
}
