package Testautomation_2004;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestDopDownandMultiSelectOperation {
    WebDriver driver;
 public void invokeBrowser()
 {

     try {

         System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // testDropDown();
         //testMultiple();
         //test_Table();
         test_Wait();

     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
 }
 public void testDropDown()
 {
     driver.get("https://www.toolsqa.com/automation-practice-form/");
     Select oDropDown = new Select(driver.findElement(By.id("continents")));
     oDropDown.selectByIndex(1);
     oDropDown.selectByVisibleText("Africa");
     List<WebElement> elmCount = oDropDown.getOptions();
     int iSize = elmCount.size();
     for(int i = 0; i<iSize;i++)
     {
         String sValue = elmCount.get(i).getText();
         System.out.println(sValue);
     }
 }


 public void testMultiple()
 {
     driver.get("https://www.toolsqa.com/automation-practice-form/");
     Select oMultiple = new Select(driver.findElement(By.name("selenium_commands")));

     oMultiple.selectByIndex(0);
     oMultiple.deselectByIndex(0);
     oMultiple.selectByVisibleText("Navigation Commands");
     oMultiple.deselectByVisibleText("Navigation Commands");

     List<WebElement> elmCount = oMultiple.getOptions();
     int iSize = elmCount.size();
     for(int i = 0; i < iSize; i++)
     {
         String sValue = elmCount.get(i).getText();
         System.out.println(sValue);
     }

     oMultiple.deselectAll();
 }
 public void test_Table()
 {
     driver.get("http://toolsqa.com/automation-practice-table");
     String sCelValue = driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
     System.out.println(sCelValue);

     driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")).click();
 }

 public void test_Wait()
 {
     driver.get("http://toolsqa.com/automation-practice-switch-windows/");
     WebElement btn_Alert = driver.findElement(By.id("timingAlert"));
     Actions actions = new Actions(driver);
     actions.moveToElement(btn_Alert).click().build().perform();


     System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");

     WebDriverWait wait = new WebDriverWait(driver, 5);
     Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
     System.out.println("Either Pop Up is displayed or it is Timed Out");
     myAlert.accept();
     System.out.println("Alert Accepted");
 }
 @Test
 public void test_dropdown_multiple()
 {
     TestDopDownandMultiSelectOperation myObj = new TestDopDownandMultiSelectOperation();
     myObj.invokeBrowser();
 }
}
