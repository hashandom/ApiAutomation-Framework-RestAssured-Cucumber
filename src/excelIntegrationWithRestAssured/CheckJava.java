package excelIntegrationWithRestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CheckJava {

	public static void main(String[] args) throws IOException {
		XSSFSheet testdataSheet = null;
		int column = 0;

		FileInputStream fileNew = new FileInputStream(
				"\"C:\\Users\\user\\Desktop\\api-testing\\excel-data-intergration.xlsx\"");
		XSSFWorkbook workbook = new XSSFWorkbook(fileNew);

		int sheetCount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetCount; i++) {
			String sheetname = workbook.getSheetName(sheetCount);

			if (sheetname.equalsIgnoreCase("testdata")) {
				testdataSheet = workbook.getSheetAt(i);

			}
		}

		Iterator<Row> row = testdataSheet.iterator();
		Row firstRow = row.next();

		Iterator<Cell> cell = firstRow.cellIterator();

		int k = 0;
		while (cell.hasNext()) {
			cell.next();
			String cellValue = cell.next().getStringCellValue();

			if (cellValue.equalsIgnoreCase("Test")) {
				column = k;
			}
			k++;
		}

		while (row.hasNext()) {
			Row r = row.next();
		String cellValue=	r.getCell(column).getStringCellValue();
		if(cellValue.equalsIgnoreCase("Purchase")) {
			Iterator<Cell> cell1 = r.cellIterator();
			while(cell1.hasNext()) {
				System.out.println(cell1.next().getStringCellValue());
			}
		}
		
		}
	}

}
