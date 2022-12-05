package TestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class facebook {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/mariiashkolnik/Documents/AQA/hw5/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=1600506868&extra_1=s%7Cc%7C303839676198%7Ce%7Cfacebook%7C&placement=&creative=303839676198&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D1600506868%26adgroupid%3D60825658456%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-541132862%26loc_physical_ms%3D1012835%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwwL6aBhBlEiwADycBIFvHzXMYv-hCAjLy00-YPgA11D4syHitHwa4ziloEiVZFJEcZfuUlxoClCIQAvD_BwE");
    }
    @Test
    public void method1() throws InterruptedException {
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.xpath(".//*[@name='firstname']"));
        firstName.sendKeys("Test");
        Thread.sleep(1000);

        WebElement lastname = driver.findElement(By.xpath(".//*[@name='lastname']"));
        lastname.sendKeys("Test");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.xpath(".//*[@name='reg_email__']"));
        email.sendKeys("Test@gmail.com");
        Thread.sleep(1000);

        WebElement confirmEmail = driver.findElement(By.xpath(".//*[@name='reg_email_confirmation__']"));
        confirmEmail.sendKeys("Test@gmail.com");
        Thread.sleep(1000);

        WebElement pass = driver.findElement(By.xpath(".//*[@name='reg_passwd__']"));
        pass.sendKeys("Testseta123456");
        Thread.sleep(1000);

        Select day = new Select(driver.findElement(By.xpath(".//*[@name='birthday_day']")));
        day.selectByValue("6");
        Thread.sleep(1000);

        Select month = new Select(driver.findElement(By.xpath(".//*[@name='birthday_month']")));
        month.selectByValue("1");
        Thread.sleep(1000);

        Select year = new Select(driver.findElement(By.xpath(".//*[@name='birthday_year']")));
        year.selectByValue("2012");
        Thread.sleep(1000);

        WebElement gender = driver.findElement(By.xpath(".//*[@name='sex' and @value='2']"));
        gender.click();
        Thread.sleep(1000);
    }

    @Test
    public void method2() throws InterruptedException {
        WebElement firstNameText = driver.findElement(By.xpath(".//*[@name='firstname']"));
        String ActualFirstName = firstNameText.getAttribute("value");
        String ExpectedFirstName = "Test";
        Assert.assertEquals(ExpectedFirstName, ActualFirstName);

        WebElement lastnameText = driver.findElement(By.xpath(".//*[@name='lastname']"));
        String ActualLastname = lastnameText.getAttribute("value");
        String ExpectedLastname = "Test";
        Assert.assertEquals(ExpectedLastname, ActualLastname);

        WebElement emailText = driver.findElement(By.xpath(".//*[@name='reg_email__']"));
        String ActualEmail = emailText.getAttribute("value");
        String ExpectedEmail = "Test@gmail.com";
        Assert.assertEquals(ExpectedEmail, ActualEmail);

        WebElement confirmEmailText = driver.findElement(By.xpath(".//*[@name='reg_email_confirmation__']"));
        String ActualConfirmEmail = confirmEmailText.getAttribute("value");
        String ExpectedConfirmEmail = "Test@gmail.com";
        Assert.assertEquals(ExpectedConfirmEmail, ActualConfirmEmail);

        WebElement passTetx = driver.findElement(By.xpath(".//*[@name='reg_passwd__']"));
        String ActualConfirmPassTetx = passTetx.getAttribute("value");
        String ExpectedConfirmPassTetx = "Testseta123456";
        Assert.assertEquals(ExpectedConfirmPassTetx, ActualConfirmPassTetx);

        WebElement genderRadio = driver.findElement(By.xpath(".//*[@name='sex' and @value='2']"));
        Assert.assertEquals(true, genderRadio.isSelected());
        Thread.sleep(1000);
    }

    @Test
    public void method3() throws InterruptedException {
        boolean submit = driver.findElement(By.xpath(".//button[@type='submit' and @name='websubmit']")).isEnabled();
        Thread.sleep(1000);
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
    }
}
