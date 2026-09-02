package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadData {

    static String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";

    static FileInputStream fileInputStream;


    static {
        try {
            fileInputStream = new FileInputStream(testDataDir);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ReadData() throws IOException{

    }

    static XSSFSheet sheet = workbook.getSheet("Login Details");

    public static String username = sheet.getRow(1).getCell(0).getStringCellValue();
    public static String password = sheet.getRow(1).getCell(1).getStringCellValue();
//    public static String wrong = sheet.getRow(3).getCell(0).getStringCellValue();
//    public static String wrongpass = sheet.getRow(2).getCell(1).getStringCellValue();

//    @Test
//    public void testData(){
//       System.out.println("Username: " + username);
//       System.out.println("Password: " + password);
//       System.out.println("wrong user: " + wrong);
//       System.out.println("wrong password: " + wrongpass);
//    }






}
