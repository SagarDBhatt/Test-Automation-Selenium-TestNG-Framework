import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UAT_TestNG {

    WebDriver driver;

    /**
     * Initiate the driver for the Chrome browser.
     */
    @BeforeTest
    public void initiate_drivers(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    /**
     * Login to the NC-TT UAT environment
     * @throws InterruptedException
     */
    @Test
    public void login_func() throws InterruptedException {
        driver.get("https://uat.wl-netcrackertt-np-dev.aws.dishcloud.io/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String original_title = driver.getTitle();
        String expected_title = "Netcracker 2020.3";

        Assert.assertEquals(original_title,expected_title);
//        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.id("user"));
        userName.sendKeys("Sagar Bhatt");
//        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Ons@jhj@sa1087NC");
//        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td[3]/div[2]/div/input")).click();
        Thread.sleep(2000);

        // DD date
        ////*[@id="vv_9159564715113384300"]/span/span

    }

//    /**
//     * Method to execute TC-1 - Create Organization.
//     * @throws InterruptedException
//     */
//    @Test(dependsOnMethods = {"login_func"})
//    public void create_organization() throws InterruptedException {
//        //gen_menu_0
//
//       driver.findElement(By.id("gen_menu_0")).click();
//       Thread.sleep(2000);
//
//       driver.findElement(By.xpath("//*[@id=\"9159653810613294400\"]/span")).click();
//       Thread.sleep(4000);
//
//       driver.findElement(By.xpath("//*[@id=\"9159524472013250559\"]/div/div[4]/div[2]/div[2]/div/div/div/div/div/button")).click();
//       Thread.sleep(2000);
//
//       driver.findElement(By.xpath("//*[@id=\"-1\"]")).sendKeys("DISH_Internal_Script1");
//       Thread.sleep(2000);
//
//       driver.findElement(By.xpath("//*[@id=\"9159715801513250735\"]")).sendKeys("DISH_DBA_Script1");
//       Thread.sleep(4000);
//
//       driver.findElement(By.xpath("//*[@id=\"id_refsel566362226_div\"]/div/i")).click();
//       Thread.sleep(2000);
//       //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//
//       driver.findElement(By.xpath("//*[@id=\"nc_refsel_list_row_0\"]")).click();
//       Thread.sleep(2000);
//       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//
//    }

    /**
     * Fetch the Due date reflected in NC-TT for the site id #DNLIT340390A. The due date passed from NXO.
     * This scenario validate the payload coming from NXO to NC-TT.
     */
    @Test(dependsOnMethods = {"login_func"})
    public void fetchDueDate_NCTT() throws InterruptedException {
        driver.findElement(By.id("gen_menu_0")).click();
//        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"9159321972613278525\"]/span")).click();
//        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"div_t9159460587513349434_0____9159561908313383331\"]/img")).click();
//        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"attrIDDiv\"]/div[3]/input")).sendKeys("DNLIT340390A");
//        Thread.sleep(1000);

        // Apply button click - diabled.
//        driver.findElement(By.xpath("//*[@id=\"attrIDDiv\"]/div[4]/div[1]/div/a")).click();
//        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"fvalues\"]/li/a")).click();
        Thread.sleep(1000);

        //click on "Name - hyperlink (<a>)
        driver.findElement(By.xpath("//*[@id=\"t9159460587513349434_0_t\"]/tbody/tr/td[2]/a/span")).click();
        Thread.sleep(1000);

        //Click on Sub-requests in the left pane.
        driver.findElement(By.xpath("//*[@id=\"id_tab_6\"]/a")).click();
        Thread.sleep(1000);

        //Click on New xHaul Access Sub-request #048413
        driver.findElement(By.xpath("//*[@id=\"t9132848641513627267_0_t\"]/tbody/tr[2]/td[2]/a/span")).click();
        Thread.sleep(1000);

        //Click on New xHaul Access Sub-request #048413 -> "General Information" in left pane.
        driver.findElement(By.xpath("//*[@id=\"id_tab_1\"]/a")).click();
        Thread.sleep(1000);

        /**
         * Due date is at the bottom of the page. I need to scroll to find the element. Below are the steps.
         * 1. Find the element using x-path.
         * 2. find the "Y" coordinates of the element.
         *
         */
        WebElement dueDateElement = driver.findElement(By.xpath("//*[@id=\"vv_9159564715113384300\"]/span/span"));
        int y_coordinates = dueDateElement.getLocation().getY();
        System.out.println("Y Co-ordinate of the element = " + y_coordinates);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeAsyncScript("window.scrollTo(0,"+y_coordinates+")");
        Thread.sleep(1000);
    }

//    @AfterTest
//    public void close_browser(){
//        driver.close();
//    }

}
