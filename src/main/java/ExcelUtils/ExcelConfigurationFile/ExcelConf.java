package ExcelUtils.ExcelConfigurationFile;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelConf {

    public static void getRowCount() throws IOException {
//        System.out.println("Inside the method");
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework\\src\\main\\java\\ExcelUtils\\ExcelConfigurationFile\\confData.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println("Last row " + sheet.getLastRowNum());
        System.out.println("Pysical Count = " + sheet.getPhysicalNumberOfRows());
    }



    public static void main(String[] args) throws IOException {
        getRowCount();
    }

}
