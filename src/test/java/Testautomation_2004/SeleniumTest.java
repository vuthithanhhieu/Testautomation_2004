package Testautomation_2004;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class SeleniumTest {
    //DROPDOWN AND MULTIPLE SELECT OPERATIONS
    @Test
    @Ignore
    public void Dropdown_and_multipale_select_operations()
    {


    }
    // Checkbox, Radio button...
    @Test
    @Ignore
    public void Check_Box_and_Radio_Btn()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement txtEmail = driver.findElement(By.name("firstname"));
        WebElement txtPassword = driver.findElement(By.name("lastname"));
        txtEmail.sendKeys("Hieu");
        txtPassword.sendKeys("Vtt");
        driver.findElement(By.partialLinkText("Partial ")).click();
        driver.findElement(By.partialLinkText("Link"));
        //driver.findElement(By.id("submit")).click();

        // Step 3 : Select the deselected Radio button (female) for category Sex (Use IsSelected method)
        // Storing all the elements under category 'Sex' in the list of WebLements
        List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));

        // Create a boolean variable which will hold the value (True/False)
        boolean bValue = false;

        // This statement will return True, in case of first Radio button is selected
        bValue = rdBtn_Sex.get(0).isSelected();

        // This will check that if the bValue is True means if the first radio button is selected
        if(bValue == true){
            // This will select Second radio button, if the first radio button is selected by default
            rdBtn_Sex.get(1).click();
        }
        //Step 4: Select the Third radio button for category 'Years of Exp' (Use Id attribute to select Radio button)
        WebElement rdBtn_Exp = driver.findElement(By.cssSelector("input[value='3']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(rdBtn_Exp).click().build().perform();

        // STep 5: Check the Check Box 'Automation Tester' for category 'Profession'( Use Value attribute to match the selection)
        // Find the Check Box or radio button element by Name
        List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

        // This will tell you the number of Check Boxes are present
        int iSize = chkBx_Profession.size();

        // Start the loop from first Check Box to last Check Boxe
        for(int i=0; i < iSize ; i++ ){
            // Store the Check Box name to the string variable, using 'Value' attribute
            String sValue = chkBx_Profession.get(i).getAttribute("value");

            // Select the Check Box it the value of the Check Box is same what you are looking for
            if (sValue.equalsIgnoreCase("Automation Tester")){
                //chkBx_Profession.get(i).click();
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(chkBx_Profession.get(i)).click().build().perform();
                // This will take the execution out of for loop
                break;
            }
        }
        // Step 6: Check the Check Box 'Selenium IDE' for category 'Automation Tool' (Use cssSelector)
        WebElement oCheck_Box = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
        actions.moveToElement(oCheck_Box).click().build().perform();

        // Kill the browser
        driver.quit();

    }



    @Test
    @Ignore
    public  void tcbs_ibond()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tcinvest.tcbs.com.vn/guest/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement txtEmail = driver.findElement(By.id("mat-input-0"));
        WebElement txtPassword = driver.findElement(By.id("mat-input-1"));
        txtEmail.sendKeys("105C758620");
        txtPassword.sendKeys("ncqlkn");

        driver.findElement(By.cssSelector(".btn-login")).click();
        Actions action = new Actions(driver);
        WebElement order = driver.findElement(By.cssSelector("div.icon-image"));

        action.moveToElement(order, 10, 10).click().perform();
        driver.quit();

    }

    @Test
    @Ignore
    public void shopingAdayroi()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.adayroi.com/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement txtSearch =  driver.findElement(By.cssSelector("div.input-group input[type=\"text\"]"));

        txtSearch.sendKeys("tra xanh");

        txtSearch.sendKeys(Keys.ENTER);
        Actions action =  new Actions(driver);

       List<WebElement> menuitem = driver.findElements(By.cssSelector("div.product-item"));
       int total = menuitem.size();
       Random rd = new Random();
       int focusIndex = rd.nextInt(total);
       WebElement buyProductItem = menuitem.get(focusIndex);
       buyProductItem.click();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       WebElement cart = driver.findElement(By.cssSelector("button.d-button--buy-now"));
       cart.click();

       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       WebElement login = driver.findElement(By.cssSelector("button.btn-facebook"));
       login.click();

       //buyProductItem.findElement(By.cssSelector(""));


       /* action.moveToElement(menuitem, 10,10).perform();
        action.click().perform();
        WebElement detailitem = driver.findElement(By.cssSelector("div.product-variant__item-value"));

        action.moveToElement(detailitem, 10,10);
        action.click().perform(); */

    }
    @Test
    @Ignore
    public void StartingWithSelenium()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.vn/"); // Hay dùng khi mở page lần đầu để test

        //Cách mở khác
        driver.navigate().to("https://www.google.com.vn/"); // thường được dùng khi page đang mở nhưng  mình chuyển sang 1 page khác

        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("Length is: " + title.length());
        String geturl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.google.com.vn/", geturl);
        String Pagesource = driver.getPageSource();
        System.out.println(Pagesource);
        System.out.println("Length page source is: " + Pagesource.length());

        driver.quit();
    }

    @Test
    @Ignore
    public  void goodleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.get("https://www.google.com.vn/");

       // WebElement txtSearchBox = driver.findElement(By.name("q"));
       // txtSearchBox.sendKeys("Facebook");
        //txtSearchBox.sendKeys(Keys.ENTER);

       // WebElement txtSearchBox = driver.findElement(By.name("q"));
        //txtSearchBox.sendKeys("Testmaster");



       // txtSearchBox.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
      /*  txtSearchBox.sendKeys(Keys.chord(Keys.CONTROL, "a")); //Ctrl+A
        txtSearchBox.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        txtSearchBox.sendKeys(Keys.END);
        txtSearchBox.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        txtSearchBox.sendKeys(Keys.ENTER); */
        // Action là 1 class mô phỏng tất cả các hd liên quan đến bàn phím và chuột
       // Actions action = new Actions(driver);
       /* action.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();
        action.sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();
        action.sendKeys(Keys.END);
        action.sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();
        action.sendKeys(Keys.chord(Keys.CONTROL, "v")).perform(); */


        driver.get("http://maiden.vn");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
        WebElement btnClose = driver.findElement(By.cssSelector("a.close-tannm-modal"));
        Actions action = new Actions(driver);
        action.moveToElement(btnClose, 10, 10).click().perform();

        WebElement menuitem = driver.findElement(By.cssSelector(".secondary-header a[href=\"/c1/van-phong-pham.html\"]")); //"div.scroller .product-item"
        action.moveToElement(menuitem, menuitem.getSize().width/2, menuitem.getSize().height/2).perform();


        //Truwongf howpj khoong xacs ddinhj element

        action.moveByOffset(20,100).perform();


        //Mở chuột phải
        action.contextClick().perform();

    }

    @Test
    @Ignore
    // Ham WAIT

    public void shouldAnswerWhithTrue()
    {
        WebDriver driver = new ChromeDriver();
        //implicitlyWait - Lệnh chờ bị động
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Lệnh của Java: Thread.sleep(1000); //mls

        //Lênh chờ chủ động

        WebDriverWait waiter  = new WebDriverWait(driver, 10);
       // waiter.until(ExpectedConditions.invisibilityOf(element)); //Xác định điều kiện chờ element

    }

    @Test
    @Ignore
    public void loginMaster() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thanh\\Documents\\Automation\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testmaster.vn/admin");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement txtemail = driver.findElement(By.cssSelector("input[type='email']"));

        WebElement txtpass = driver.findElement(By.cssSelector("input[type='password']"));
        txtemail.sendKeys("123@gmail.com");
        txtpass.sendKeys("123456");

        driver.findElement(By.cssSelector(".btn-login")).click();
        WebDriverWait waiter = new WebDriverWait(driver, 30);

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert")));

        Thread.sleep(1000);
        WebElement popup = driver.findElement(By.cssSelector("div.alert"));
       String messageText =  popup.findElement(By.cssSelector(".body-message")).getAttribute("innerText");
       Assert.assertEquals("Tên đăng nhập hoặc Mật khẩu không đúng.", messageText);



    }



    @Test
    @Ignore
    public void Selecttion(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\thanh\\Documents\\Automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String URL = "https://serenity.testmaster.vn/dom.html";
        driver.get(URL);
        WebElement txtfistname = driver.findElement(By.name("fname"));
        WebElement txtlastname = driver.findElement(By.name("lname"));
        txtfistname.sendKeys("Hieu");
        txtlastname.sendKeys("Vu");
        WebElement List = driver.findElement(By.cssSelector("select"));
        //Chuyển webElement của selenium về đối tượng select thông qua class select

        Select slist = new Select(List);
        slist.selectByValue("audi");
        slist.selectByIndex(2);
        //Để biết các item của selection
        java.util.List<WebElement> lsOption =  List.findElements(By.cssSelector("option"));
        int total = lsOption.size();

        //với Checkbox và radio
        //Có 2 hđ chính khi làm việc với checkbox
        //1. Kiểm tra xem có đc chọn
        //2. Check/Uncheck vào nó
        WebElement chkHappy= driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"1\"]"));
        //Kiểm tra xem có đc check
        Boolean value= chkHappy.isSelected();
        //Nếu muốn check vào thì
        if(!value) {
            chkHappy.click();
        }

        //Get text có định dạng
        WebElement txtThongbao = driver.findElement(By.cssSelector("div.thongbao"));
        String strContent  = txtThongbao.getAttribute("innerText");
        //Get placeholder
        System.out.println(txtfistname.getAttribute("placeholder"));

        System.out.println();
        driver.close();
    }

}
