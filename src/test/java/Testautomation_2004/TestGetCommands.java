package Testautomation_2004;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestGetCommands {
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
        getCommands();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void getCommands()
    {
        try {
            driver.get("https://www.amazon.in/");
            String titleofthePage = driver.getTitle();
            System.out.println("Title of the page is: " + titleofthePage);
            driver.findElement(By.linkText("Today's Deals")).click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println("The current URL is: " + currentUrl);
            System.out.println("The current page source is: "+ driver.getPageSource());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public static  void main(String[] args)
    {
        TestGetCommands myObj = new TestGetCommands();
        myObj.invokeBroser();

    }
}
