package Testautomation_2004;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestNavigateCommands {
    WebDriver driver;
    public void invokeBroser()
    {
        try {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            navigateCommands();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void navigateCommands()
    {
        try {
            driver.navigate().to("https://www.flipkart.com/");
            driver.findElement(By.xpath("button[@class='_2AkmmA _29YdH8']")).click();
            //Actions action = new Actions(driver);
            //action.moveToElement(tbn_ads, 10, 10).click().perform();
            driver.findElement(By.xpath("//span[contains(text(), 'TVs & Appliances')]")).click();
            driver.findElement(By.xpath("//li[@class='_1KCOnI _3ZgIXy']//a[contains(text(),'Microwave Ovens')]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().forward();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    @Ignore
    public void test_navigate()
    {
        TestNavigateCommands myObj = new TestNavigateCommands();
        myObj.invokeBroser();
    }

}
