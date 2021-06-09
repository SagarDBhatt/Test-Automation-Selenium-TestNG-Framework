package Screenshot_Handle;

import Driver_Utility.ChromeDriverUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screenshot_Utility {

    public static void main(String[] args) throws IOException, InterruptedException {
        Screenshot_Utility object = new Screenshot_Utility();

        WebDriver driver = ChromeDriverUtility.getChromeDriver();
        driver.get("https://dishuat.nexsysone.com/nexsysonev3/app#projectone/control");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        object.captureScreenshot(driver, "home");
        Thread.sleep(2000);

    }

    public void captureScreenshot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        File outputFile = new File("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework\\src\\main\\java\\Screenshot_Handle\\"+fileName+".png");

        FileUtils.copyFile(srcFile,outputFile);

    }
}
