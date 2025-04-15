package excelIntegrationWithRestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static ArrayList<String> getData(String testCase) throws IOException {
		int column = 0;
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fileNew = new FileInputStream(
				"\"C:\\Users\\user\\Desktop\\api-testing\\excel-data-intergration.xlsx\"");
		XSSFWorkbook workbook = new XSSFWorkbook(fileNew);

		int countSheet = workbook.getNumberOfSheets();

		for (int i = 0; i < countSheet; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheetData = workbook.getSheetAt(i);

				// identify the Testcases column by scan the entire 1st row
				Iterator<Row> rows = sheetData.iterator();
				int k = 0;
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				while (cells.hasNext()) {
					Cell value = cells.next();
					String cellValue = value.getStringCellValue();
					if (cellValue.equalsIgnoreCase("Test")) {
						column = k;
					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					String colName = r.getCell(column).getStringCellValue();
					if (colName.equalsIgnoreCase(testCase)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							String cellValue = cv.next().getStringCellValue();
							a.add(cellValue);
						}
					}

				}

			}
		}
			return a;
	}

	public static void main(String[] args) throws IOException {
		

	}

}