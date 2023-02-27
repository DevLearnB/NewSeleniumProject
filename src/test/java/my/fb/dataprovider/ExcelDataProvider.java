package my.fb.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataProvider {

	@DataProvider(name = "searchTerms")
	public static String[][] searchTerms() {
		String[][] str = new String[][] {{"1abc12@gmail.com" ,  "Abctest123$"}, {"1abc123@gmail.com" ,  "Abctest1234$"}};

		return 	str;
	}

	@DataProvider(name = "loginData")
	public static String[][] dataFromExcel() throws IOException {

		File logindata = new File("./src/test/resources/Data.xlsx");

		FileInputStream fs = new FileInputStream(logindata);

		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//XSSFRow row = sheet.getLastRowNum();
		int dataRowCount = sheet.getLastRowNum();
		int totalRowCount = sheet.getPhysicalNumberOfRows();
		int totalColmuns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[totalRowCount-1][totalColmuns];
		for(int i = 0; i < totalRowCount-1; i++) {
			for(int j = 0; j < totalColmuns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(df.formatCellValue(sheet.getRow(i+1).getCell(j)));

			}

			System.out.println();
		}

		for(String[] s: data) {

			System.out.println(Arrays.toString(s));
		}

		return data;
	}



	public static void main(String[] args) throws IOException {
		dataFromExcel();
	}

}
