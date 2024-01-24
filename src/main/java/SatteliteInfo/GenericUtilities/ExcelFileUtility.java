package SatteliteInfo.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class has methods for Handling Excel Sheets
 * 
 * @author kravi
 */
public class ExcelFileUtility {

	/**
	 * This Method Reads Data from Excel Sheet
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readDataFromExcelSheet(String sheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fise = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	/**
	 * This Method writes data in Excel Sheet
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws IOException
	 */

	public void writeDateintoExcelSheet(String sheetName, int row, int cell, String value) throws IOException {
		FileInputStream fise = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);

		FileOutputStream fose = new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fose);
		System.out.println(value + " --> data added");
		wb.close();

	}

	/**
	 * This Method Counts No of Rows in Excel sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fise = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	/**
	 * This Method will Read the data from Excel Sheet and return it to data
	 * Provider
	 * 
	 * @param Sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
