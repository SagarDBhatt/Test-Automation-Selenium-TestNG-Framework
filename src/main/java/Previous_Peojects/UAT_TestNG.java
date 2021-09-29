package Previous_Peojects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UAT_TestNG {

    WebDriver driver;
    JavascriptExecutor jsExecutor;
    int initial_val = 3007;

    /**
     * Initiate the driver for the Chrome browser.
     */
    @BeforeTest
    public void initiate_drivers(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(invocationCount = 245)
    public void NNI_values_ver3() throws InterruptedException {

        driver.get("https://user.wl-netcrackertt-p.aws.dishcloud.io/common/uobject.jsp?tab=_VLAN+Subinterfaces&object=9160400727213539202&site=9160385261313412985");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"9131396189313885269\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"id_number_input\"]")).sendKeys(String.valueOf(initial_val));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nc_refsel_list_row_0\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"id_vlanID_input\"]")).sendKeys(String.valueOf(initial_val));
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[17]/div/div/div[3]/div/button[1]")).click();
        Thread.sleep(4000);

        initial_val += 2;
    }

//    @Test(invocationCount = 240)
    public void NNI_values_hundredGig() throws InterruptedException {

        driver.get("https://user.wl-netcrackertt-p.aws.dishcloud.io/common/uobject.jsp?tab=_VLAN+Subinterfaces&object=9160390662813424358&site=9160385261713413285");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"9131396189313885269\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"id_number_input\"]")).sendKeys(String.valueOf(initial_val));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nc_refsel_list_row_0\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"id_vlanID_input\"]")).sendKeys(String.valueOf(initial_val));
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[17]/div/div/div[3]/div/button[1]")).click();
        Thread.sleep(4000);

        initial_val += 2;
    }

    int initial_value = 3471;
//    @Test(invocationCount = 2)
    public void NNI_values() throws InterruptedException {

        driver.get("https://user.wl-netcrackertt-p.aws.dishcloud.io/common/uobject.jsp?tab=_VLAN+Subinterfaces&object=9160390668713424358&site=9160385261713413285");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form/table/tbody/tr/td/table[1]/tbody/tr/td[1]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[17]/div/div/div[2]/form/div[2]/table/tbody/tr[2]/td[2]/div/div/input")).sendKeys(String.valueOf(initial_value));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[18]/div[2]/div[1]/div[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"id_vlanID_input\"]")).sendKeys(String.valueOf(initial_value));
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[17]/div/div/div[3]/div/button[1]")).click();
        Thread.sleep(4000);

        initial_value += 2;
    }




//    @Test(invocationCount = 5)
    public void step8_CircuitDesignReviewResourceAssignment() throws InterruptedException {

        driver.get("https://user.wl-netcrackertt-p.aws.dishcloud.io/admin/users/groups.jsp?tab=_My+Tasks&group=101&object=9160261121513304289");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        /**
         * Click on filter icon to find only "Circuit design review and Resource Assignment" orders.
         * In the search box insert "Circuit design review and Resource Assignment" and hit apply.
         */
//        driver.findElement(By.xpath("//*[@id=\"dx_t6042658144013706086_0____$1_c\"]")).click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//*[@id=\"t6042658144013706086_0___typein\"]")).sendKeys("Circuit design review and Resource Assignment");
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//*[@id=\"jsFilterFirstCtrl\"]")).click();
//        Thread.sleep(4000);


        /**
         * Select the “Circuit design review and Resource Assignment” task that belongs to the Transport Request created before by clicking on the task name:
         */
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form/table/tbody/tr/td/div[3]/table/tbody/tr[1]/td[2]/a")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);


        /**
         * Once in the context of this task, we will have to create a Physical Link in the Edge Data Center and the Dark Fiber Circuit.
         * To access the Physical Link, click on the circuit the provider information:
         */
        driver.findElement(By.xpath("//*[@id=\"t9159407595113329257_0_t\"]/tbody/tr[1]/td[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);



        /**
         * First select the carrier name and add
         */
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//*[@id=\"t9132623373613407786_0_tbody\"]/tr[1]/td[3]"))).perform();
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/table/tbody/tr/td/div[3]/table/tbody/tr[1]/td[3]/div/div/div/table/tbody/tr/td[2]/div/div/input")).sendKeys("PCH-04U");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"nc_refsel_list_row_0\"]")).click();
        Thread.sleep(3000);

        /**
         * Click on the pencil at the “Resource” field for Physical Link Point A to select the LC Double-1/1 connector.
         * You can identify it by looking at the breakdown under each device and see to in which location this device is (Region>Market>AIO).
         * Click on it to select it and:
         */
        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/table/tbody/tr/td/div[3]/table/tbody/tr[1]/td[4]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"jxctl_a_input\"]")).sendKeys("LC Double-1/1");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/div[2]/div[1]/div[1]")).click();

        /**
         * Hit "Save" button
         */
        driver.findElement(By.xpath("//*[@id=\"9132623373613407786_0_save\"]")).click();
        Thread.sleep(1000);

        /**
         * Hit "Return to the task"
         */
        driver.findElement(By.xpath("//*[@id=\"user-task-context_item_1\"]")).click();
        Thread.sleep(1000);

        /**
         * To access the Dark Fiber circuit, click on the circuit without provider information:
         */
        driver.findElement(By.xpath("//*[@id=\"t9159407595113329257_0_t\"]/tbody/tr[2]/td[2]/a/span")).click();
        Thread.sleep(1000);


        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/table/tbody/tr/td/div[3]/table/tbody/tr[1]/td[4]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"jxctl_a_input\"]")).sendKeys("TenGig");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/div[2]/div[1]/div[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[1]/table/tbody/tr/td/table[1]/tbody/tr/td[1]/a")).click();
        Thread.sleep(2000);


        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/div[3]/table/tbody/tr[1]/td[3]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"jxctl_a_input\"]")).sendKeys("FCC");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/div[2]/div[1]/div[1]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/form[2]/table/tbody/tr/td/table[1]/tbody/tr/td[1]/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/span/span/div/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/span/span/div[1]/a")).click();
        Thread.sleep(5000);
    }




//    /**
//     * Login to the NC-TT UAT environment
//     * @throws InterruptedException
//     */
//    @Test
//    public void login_func() throws InterruptedException {
//        driver.get("https://uat.wl-netcrackertt-np-dev.aws.dishcloud.io/");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        String original_title = driver.getTitle();
//        String expected_title = "Netcracker 2020.3";
//
//        Assert.assertEquals(original_title,expected_title);
//        Thread.sleep(2000);
//
//        WebElement userName = driver.findElement(By.id("user"));
//        userName.sendKeys("Sagar Bhatt");
//        Thread.sleep(2000);
//
//        WebElement password = driver.findElement(By.id("pass"));
//        password.sendKeys("Ons@jhj@sa1087NC");
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td[3]/div[2]/div/input")).click();
//        Thread.sleep(2000);
//
//        // DD date
//        ////*[@id="vv_9159564715113384300"]/span/span
//
//    }
//
////    /**
////     * Method to execute TC-1 - Create Organization.
////     * @throws InterruptedException
////     */
////    @Test(dependsOnMethods = {"login_func"})
////    public void create_organization() throws InterruptedException {
////        //gen_menu_0
////
////       driver.findElement(By.id("gen_menu_0")).click();
////       Thread.sleep(2000);
////
////       driver.findElement(By.xpath("//*[@id=\"9159653810613294400\"]/span")).click();
////       Thread.sleep(4000);
////
////       driver.findElement(By.xpath("//*[@id=\"9159524472013250559\"]/div/div[4]/div[2]/div[2]/div/div/div/div/div/button")).click();
////       Thread.sleep(2000);
////
////       driver.findElement(By.xpath("//*[@id=\"-1\"]")).sendKeys("DISH_Internal_Script1");
////       Thread.sleep(2000);
////
////       driver.findElement(By.xpath("//*[@id=\"9159715801513250735\"]")).sendKeys("DISH_DBA_Script1");
////       Thread.sleep(4000);
////
////       driver.findElement(By.xpath("//*[@id=\"id_refsel566362226_div\"]/div/i")).click();
////       Thread.sleep(2000);
////       //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
////
////       driver.findElement(By.xpath("//*[@id=\"nc_refsel_list_row_0\"]")).click();
////       Thread.sleep(2000);
////       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
////
////    }
//
//    /**
//     * Fetch the Due date reflected in NC-TT for the site id #DNLIT340390A. The due date passed from NXO.
//     * This scenario validate the payload coming from NXO to NC-TT.
//     */
//    @Test(dependsOnMethods = {"login_func"})
//    public void fetchDueDate_NCTT() throws InterruptedException {
//        driver.findElement(By.id("gen_menu_0")).click();
//        Thread.sleep(4000);
//
//        driver.findElement(By.xpath("//*[@id=\"9159321972613278525\"]/span")).click();
//        Thread.sleep(4000);
//
//        driver.findElement(By.xpath("//*[@id=\"div_t9159460587513349434_0____9159561908313383331\"]/img")).click();
//        Thread.sleep(4000);
//
//        driver.findElement(By.xpath("//*[@id=\"attrIDDiv\"]/div[3]/input")).sendKeys("DNLIT340390A");
//        Thread.sleep(4000);
//
//        // Apply button click - diabled.
////        driver.findElement(By.xpath("//*[@id=\"attrIDDiv\"]/div[4]/div[1]/div/a")).click();
////        Thread.sleep(2000);
//
//        jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.scrollBy(0,250)");
//
//        driver.findElement(By.xpath("//*[@id=\"fvalues\"]/li/a")).click();
//        Thread.sleep(4000);
//
//        //click on "Name - hyperlink (<a>)
//        driver.findElement(By.xpath("//*[@id=\"t9159460587513349434_0_t\"]/tbody/tr/td[2]/a/span")).click();
//        Thread.sleep(1000);
//
//        //Click on Sub-requests in the left pane.
//        driver.findElement(By.xpath("//*[@id=\"id_tab_6\"]/a")).click();
//        Thread.sleep(1000);
//
//        //Click on New xHaul Access Sub-request #048413
//        driver.findElement(By.xpath("//*[@id=\"t9132848641513627267_0_t\"]/tbody/tr[2]/td[2]/a/span")).click();
//        Thread.sleep(1000);
//
//        //Click on New xHaul Access Sub-request #048413 -> "General Information" in left pane.
//        driver.findElement(By.xpath("//*[@id=\"id_tab_1\"]/a")).click();
//        Thread.sleep(1000);
//
//        /**
//         * Due date is at the bottom of the page. I need to scroll to find the element. Below are the steps.
//         * 1. Find the element using x-path.
//         * 2. find the "Y" coordinates of the element.
//         * 3. JavaScriptExecutor is required to scroll the window.
//         * 4. Here, I am scrolling the page till it finds the element.
//         */
//        WebElement dueDateElement = driver.findElement(By.xpath("//*[@id=\"vv_9159564715113384300\"]/span/span"));
//        System.out.println("Element Due Date = " + dueDateElement);
//        int y_coordinates = dueDateElement.getLocation().getY();
//        System.out.println("Y Co-ordinate of the element = " + y_coordinates);
//
////        jsExecutor.executeScript("window.scrollTo(0,"+y_coordinates+")");
////        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        jsExecutor.executeScript("scroll(0, 800);");
//
//        Thread.sleep(1000);
//    }

//    @AfterTest
//    public void close_browser(){
//        driver.close();
//    }

}
