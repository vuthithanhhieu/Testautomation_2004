package Testautomation_2004;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic02_Xpath_Css_Part_I {
    WebDriver driver;

    @BeforeClass
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01()
    {
        driver.get("");
        //1. ID
        driver.findElement(By.id(""));
        //2. Class
        driver.findElement(By.className("")).getText();
        //3. Name
        driver.findElement(By.name("")).sendKeys("");
        driver.findElement(By.name("")).clear();
        //4. Tagname
        List <WebElement> links =  driver.findElements(By.tagName("a")); //.size();
        //5. Link Text - Matching toàn bộ text bên trong
        driver.findElement(By.linkText("")).click();
        //6. Partial Text  - matching 1 phần text bên trong
        driver.findElement(By.partialLinkText("")).clear();
        //7. Css - không work với text
        driver.findElement(By.cssSelector("input[name='']"));
        //8. Xpath - work với text
        //Xpath dùng với ID
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
        //Xpath dùng với class
        driver.findElement(By.xpath("//div[@class = '']"));
        //Xpath dùng với name
        driver.findElement(By.xpath("//input[@name = '']"));
        //Xpath dùng với Link
        driver.findElement(By.xpath("//a[text() = '']"));
        //Xpath dùng với Partial
        driver.findElement(By.xpath("//a[contains(text(), '')]"));

    }

    @Test
    public void TC_01_LoginWithEmailandPasswordEmpty()
    {

    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
