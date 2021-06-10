package NXO_TC_Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BOM_ID_Validation {
    WebDriver driver = createWebdriver();

    /**
     * Method to take screenshots during the Test execution. This helps in Bug analysis.
     * @param fileName - Provide fileName to identify the screenshot.
     * @throws IOException
     */
    public void takeScreenShot(WebDriver argDriver, String fileName) throws IOException {
        WebDriver driver = argDriver;
        TakesScreenshot scrShot = (TakesScreenshot) driver;

        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework\\" +
                "src\\main\\java\\NXO_TC_Demo\\ScreenShots\\"+fileName+".png");
        FileUtils.copyFile(srcFile,destFile);
    }

    /**
     * Method created a WebDriver class object and configure for ChromeDriver. Return the driver for any method.
     * @return
     */
    public WebDriver createWebdriver(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        return driver;
    }

    @Test()
    public void loginPage() throws IOException, InterruptedException {

//        WebDriver driver = createWebdriver();

        driver.get("https://dishuat.nexsysone.com/nexsysonev3/");
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        takeScreenShot(driver,"loginScreen");

    // Below code can be done
//        WebElement OktaTileElement = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[2]/a"));
//        OktaTileElement.click();

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[2]/a")).click();
        Thread.sleep(2000);
        takeScreenShot(driver,"DISH_OKTA_Login");

        /**
         * Below code commented. When connected via LAN cable, page redirects to OKTA login page,
         * In this scenario, I need to fetch the excel workbook and provide the credentials.
         */
//        /**
//         * Access Excel workbook and fetch UserName & PWD. Standard practice to fetch secret values from Conf file rather than hard-coding.
//         */
//        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework" +
//                "\\src\\main\\java\\NXO_TC_Demo\\Configuration File\\Creds.xlsx");
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        Row row = sheet.getRow(1);
//        Cell userName = row.getCell(0);
//        Cell pwd = row.getCell(1);
//
////        System.out.println("UserName = " + userName + " pwd = " + pwd);
//        /**
//         *  Provide creds for DISH OKTA login page.
//         */
//        driver.findElement(By.xpath("/html/body/div[2]/div/main/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/span/input")).sendKeys(userName.toString());
//        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//
//        driver.findElement(By.xpath("//*[@id=\"okta-signin-password\"]")).sendKeys(pwd.toString());
//        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
//
//        takeScreenShot(driver,"OKTA_Credentials");
//
//        driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
//        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);

    }

    @Test(dependsOnMethods = {"loginPage"})
    public void getBOMId() throws InterruptedException {

        /**
         * Here, I need to manage pop up window. Selenium needs to switch the workflow to new pop up
         * window and acknowledge. After that I need to switch back to parent window element to Resume the
         * workflow.
         */
        Thread.sleep(10000);
        String parentWindowHandler = driver.getWindowHandle();
        String popUpWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        while(iterator.hasNext()){
            popUpWindowHandler = iterator.next();
        }

        driver.switchTo().window(popUpWindowHandler);
        Thread.sleep(2000);

        System.out.println("Before pop up screnn");
        driver.findElement(By.xpath("//*[@id=\"575da21e-5ab0-54bf-99f8-86cf03a88669\"]")).click();
        System.out.println("After pop up screen");
//        System.out.println("Parent Window = " + parentWindowHandler + "Pop up window = " + popUpWindowHandler);

        Thread.sleep(2000);
        driver.switchTo().window(parentWindowHandler);

        System.out.println("Before inserting the value");
        driver.findElement(By.id("jqxWidgetb8f552d3")).click();
        Thread.sleep(1000);

        System.out.println("After click");
        driver.findElement(By.id("jqxWidgetb8f552d3")).sendKeys("1833");
        Thread.sleep(1000);

    }



}
