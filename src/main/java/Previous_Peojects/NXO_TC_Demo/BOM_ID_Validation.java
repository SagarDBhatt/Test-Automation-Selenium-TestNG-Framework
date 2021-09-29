package Previous_Peojects.NXO_TC_Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
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
                "src\\main\\java\\Previous_Peojects.NXO_TC_Demo\\ScreenShots\\"+fileName+".png");
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

        driver.get("https://dishuat.nexsysone.com/nexsysonev3/");
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
//        takeScreenShot(driver,"loginScreen");

    // Below code can be done
//        WebElement OktaTileElement = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[2]/a"));
//        OktaTileElement.click();

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/div[2]/a")).click();
        Thread.sleep(2000);
        takeScreenShot(driver,"DISH_OKTA_Login");

        Thread.sleep(4000);
        takeScreenShot(driver,"HomePage");

        /**
         * Below code commented. When connected via LAN cable, page redirects to OKTA login page,
         * In this scenario, I need to fetch the excel workbook and provide the credentials.
         */
//        /**
//         * Access Excel workbook and fetch UserName & PWD. Standard practice to fetch secret values from Conf file rather than hard-coding.
//         */
//        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework" +
//                "\\src\\main\\java\\Previous_Peojects.NXO_TC_Demo\\Configuration File\\Creds.xlsx");
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
    public void getBOMId() throws InterruptedException, IOException {

        /**
         * Here, I need to manage pop up window. Selenium needs to switch the workflow to new pop up
         * window and acknowledge. After that I need to switch back to parent window element to Resume the
         * workflow.
         */
//        Thread.sleep(10000);
//        String popUpWindowHandler = null;
//
//        Set<String> handles = driver.getWindowHandles();
//        Iterator<String> iterator = handles.iterator();
//
//        while(iterator.hasNext()){
//            popUpWindowHandler = iterator.next();
//            System.out.println("Elements = " + popUpWindowHandler);
//        }
//
//        driver.switchTo().window(popUpWindowHandler);
//        Thread.sleep(2000);

        takeScreenShot(driver,"Popup_screen");
        driver.findElement(By.xpath("//*[@id=\"37c88618-31a5-ec24-e465-2fe12819b248\"]")).click();
        Thread.sleep(1000);

//        Actions actions = new Actions(driver);
//        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/input"))).perform();
//        Thread.sleep(1000);

        //Send value 1833 to input box of BOM ID to filter BOM ID
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/input")).sendKeys("1833");
        Thread.sleep(3000);
        takeScreenShot(driver,"Filter_BOM_ID");

        //Double click on the record
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[1]/div[1]/div"))).perform();
        Thread.sleep(1000);
        takeScreenShot(driver,"Popup_Detailed_Record");

    }//End of method getBOMId

}//End of class

