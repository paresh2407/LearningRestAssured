package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String sheetName = "Test Data";

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "/testData/UserData.xlsx";
		XLUtility xlUtility = new XLUtility(path);

		int rowCount = xlUtility.getRowCount(sheetName);
		int colCount = xlUtility.getCellCount(sheetName, 1);
		String[][] apiData = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String data = xlUtility.getCellData(sheetName, i, j);
				apiData[i - 1][j] = data;
			}
		}
		return apiData;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "/testData/UserData.xlsx";
		XLUtility xlUtility = new XLUtility(path);

		int rowCount = xlUtility.getRowCount(sheetName);
		String[] apiData = new String[rowCount];
		
		for(int i=1;i<=rowCount;i++) {
			apiData[i-1] = xlUtility.getCellData(sheetName, i, 1);
		}
		
		return apiData;
	}

}
