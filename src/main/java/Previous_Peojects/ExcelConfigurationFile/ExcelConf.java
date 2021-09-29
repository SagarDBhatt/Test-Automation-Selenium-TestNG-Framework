package Previous_Peojects.ExcelConfigurationFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelConf {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static DataFormatter formatter = new DataFormatter();

    /**
     * Method to access the Excel sheet and get the row counts.
     * @throws IOException
     */
    public static void getRowCount() throws IOException {
//        System.out.println("Inside the method");
        workbook = new XSSFWorkbook("C:\\Users\\sagar.bhatt\\IdeaProjects\\Test-Automation-Selenium-TestNG-Framework\\src\\main\\java\\Previous_Peojects.ExcelUtils\\ExcelConfigurationFile\\confData.xlsx");
        sheet = workbook.getSheet("Sheet1");

        /**
         * In Excel index starts with 0. Last Row count = 3 suggests that there are 4 entries with index 0,1,2,3.
         * Total entries can be found by "getPhysicalNumberOfRows()" method.
         */
        System.out.println("Last row " + sheet.getLastRowNum());
        System.out.println("Pysical Count = " + sheet.getPhysicalNumberOfRows());

        for (int i=0; i <= sheet.getLastRowNum(); i++){
            Row r = sheet.getRow(i);

            for (int j = 0; j < r.getLastCellNum(); j++){
                System.out.println(formatter.formatCellValue(getCellData(i,j)));
            }
        }
    }

    /**
     * Method to access the cell value. Method takes rowNumber and ColNumber as an argument and return the cell value.
     * @param rowNumber
     * @param columnNumber
     */
    public static Cell getCellData(int rowNumber, int columnNumber){

//        String cellData = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(columnNumber);
        return cell;
    }

    public static void main(String[] args) throws IOException {
        getRowCount();
    }

}
