package org.iitwforce.mmp.mmpprime;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	//@DataProvider(name="getExcelData1")
	public static String[][] readExcelData(String fileName,String sheetName) throws Exception{
		XSSFWorkbook workBook = new XSSFWorkbook(System.getProperty("user.dir")+"\\"+fileName);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] mydata = new String[rows][cols];
		for(int  r = 0; r < rows; r++) {
			XSSFRow row = sheet.getRow(r);

			for(int c = 0; c < cols; c++) {

				XSSFCell cell = row.getCell(c);
				if(cell!=null)
				{
					String cdata = cell.getStringCellValue();
					mydata[r][c] = cdata;
				}
				else
				{
					mydata[r][c] = "";
				}
				System.out.println(mydata[r][c] );
			}

		}
		workBook.close();
		return mydata;
	}
}




