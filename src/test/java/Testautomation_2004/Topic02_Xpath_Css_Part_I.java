package Testautomation_2004;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic02_Xpath_Css_Part_I {
    static WebDriver driver;

   @BeforeClass
    public static void  beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Ignore
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
        driver.get("http://live.guru99.com");
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(" ");
        driver.findElement(By.xpath("//button[@id='send2']")).click();

        String emailErrorMsg =  driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
        Assert.assertEquals(emailErrorMsg, "This is a required field.");

        String passErrorMsg = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
        Assert.assertEquals(passErrorMsg, "This is a required field.");

    }

    @Test
    public  void TC_02_LoginWithEmailinvalid()
    {
        driver.get("http://live.guru99.com");
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234@1234.1234");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(" ");
        driver.findElement(By.xpath("//button[@id='send2']")).click();

        String emailStrong = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
        Assert.assertEquals(emailStrong, "Please enter a valid email address. For example johndoe@domain.com.");


    }

    @Test
    public void TC_03_LoginWithPasswordless6charater()
    {
        driver.get("http://live.guru99.com");
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123 ");
        driver.findElement(By.xpath("//button[@id='send2']")).click();

        String passwordStrong = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
        Assert.assertEquals(passwordStrong, "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_LoginWithPasswordincorrect()
    {
        driver.get("http://live.guru99.com");
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();

        String passwordStrong = driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText();
        Assert.assertEquals(passwordStrong, "Invalid login or password.");
    }

    @Test
    public void TC_05_CreateAnAccount () throws Exception
    {
        driver.get("http://live.guru99.com");
        driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.xpath("//a[@class='button']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Vu");
        driver.findElement(By.id("middlename")).sendKeys("Thi Thanh");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hieu");
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("hieuvtt4" + randomNumber() +"@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("tcbs@1234");
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("tcbs@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();

        String loginsuccess = driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(loginsuccess, "Thank you for registering with Main Website Store.");



        driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

    }
    public int randomNumber()
    {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        System.out.println("Random number = " + number);
        return number;
    }


    @AfterClass
    public static void  afterClass()
    {
        driver.quit();

    }
}
