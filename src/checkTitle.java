package TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class checkTitle {
    WebDriver driver;

    @DataProvider(name = "browserProvider")
    public Object[][] getData() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }
    public void setUp(String browser) {
        if (browser == "chrome") {
            System.setProperty("webdriver.chrome.driver", "/Users/mariiashkolnik/Documents/AQA/hw5/resources/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "/Users/mariiashkolnik/Documents/AQA/hw5/resources/geckodriver");
            driver = new FirefoxDriver();
        }
    }

    @Test(dataProvider = "browserProvider")
    public void test(String browser) throws InterruptedException {
        this.setUp(browser);
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        WebElement btnAccept = driver.findElement(By.xpath(".//*[@id='L2AGLb']"));
        btnAccept.click();
        WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
        element.sendKeys("Selenium");
        Thread.sleep(1000);
        element.submit();
        Thread.sleep(1000);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}
