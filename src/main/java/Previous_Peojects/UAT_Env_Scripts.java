import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UAT_Env_Scripts {

    public static void main(String[] args) throws InterruptedException {
        UAT_Env_Scripts object = new UAT_Env_Scripts();
        object.testBrowser();
    }

    public void testBrowser() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://uat.wl-netcrackertt-np-dev.aws.dishcloud.io/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title = " + title);
        Thread.sleep(4000);

        WebElement userName = driver.findElement(By.id("user"));
        userName.sendKeys("Sagar Bhatt");
        Thread.sleep(4000);

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Ons@jhj@sa1087NC");
        Thread.sleep(4000);

//        driver.findElement(By.className("loginHiddenButton")).click();
//        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td[3]/div[2]/div/input")).click();

//        driver.quit();
    }
}
