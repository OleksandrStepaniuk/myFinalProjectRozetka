import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMethods {
    private WebDriver driver;

    public LoginMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String s) {
        return driver.findElement(By.xpath(s));
    }

    public void pressButton(String locator) {
        WebElement buttonClick = driver.findElement(By.xpath(locator));
        buttonClick.click();
    }
    public void sendK(String mail, String locator) {
        WebElement e = driver.findElement(By.xpath(locator));
        e.sendKeys(mail);
    }
    public String assertText(String locator){
        WebElement a = driver.findElement(By.xpath(locator));
        return a.getText();
    }
    public WebElement clickWhenReady(String locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
        return element;
    }
}
