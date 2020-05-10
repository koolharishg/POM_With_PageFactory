package com.facebook.pagefactory.util;

import java.util.Hashtable;

public class DataUtil {

	public static Object[][] testdata(XlsReaderBazinga xls, String testname) {
		xls = new XlsReaderBazinga(FBConstants.TEST_DATA_PATH);
		String sheetname = FBConstants.TESTDATA_SHEET;

		int testStartRowNum = 1;

		while (!xls.getCellData(sheetname, 0, testStartRowNum).equals(testname)) {
			testStartRowNum++;
		}

		System.out.println("test start row number ->" + testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate number of rows
		int rows = 0;
		while (!xls.getCellData(sheetname, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("number of rows ->" + rows);

		// calculate number of columns
		int cols = 0;
		while (!xls.getCellData(sheetname, cols, colStartRowNum).equals("")) {
			cols++;
		}
		System.out.println("number of cols ->" + cols);

		Object mydata[][] = new Object[rows][1];
		int datarow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = xls.getCellData(sheetname, cNum, colStartRowNum);
				String value = xls.getCellData(sheetname, cNum, rNum);
				table.put(key, value);
			}
			mydata[datarow][0] = table;
			datarow++;
		}

		return mydata;

	}

	public static boolean isTestExecutable(XlsReaderBazinga xls, String testname) {
		int rows = xls.getRowCount(FBConstants.TESTCASES_SHEET);
		System.out.println("number of rows in test cases sheet" + rows);
		for (int rNum = 2; rNum <= rows; rNum++) {
			String tcid = xls.getCellData(FBConstants.TESTCASES_SHEET, "TCID", rNum);
			if (tcid.equals(testname)) {
				String runmode = xls.getCellData(FBConstants.TESTCASES_SHEET, "Runmode", rNum);
				if (runmode.equals("Y"))
					return true;
				else
					return false;
			}

		}

		return false;
	}
}
