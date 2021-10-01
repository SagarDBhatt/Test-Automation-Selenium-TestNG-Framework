package TestScripts;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class TestScripts {

    static WebDriver driver = null;
    static Logger logger = LogManager.getLogger(TestScripts.class);

    @BeforeClass
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("ChromeDriver created!!");
    }

    @Test
    public void initialUrl(){
        driver.get("https://google.com");
        logger.info("Google Website opened!");
        logger.error("Error message");
        logger.fatal("Fatal message");
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
        driver.close();
    }

}
