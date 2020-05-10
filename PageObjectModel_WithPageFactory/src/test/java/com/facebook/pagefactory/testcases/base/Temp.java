package com.facebook.pagefactory.testcases.base;

import java.util.Hashtable;

import com.facebook.pagefactory.util.FBConstants;
import com.facebook.pagefactory.util.XlsReaderBazinga;

public class Temp {
	public Object[][] testdata() {
		XlsReaderBazinga xls = new XlsReaderBazinga(FBConstants.TEST_DATA_PATH);
		String sheetname = FBConstants.TESTDATA_SHEET;

		int testStartRowNum = 1;

		while (!xls.getCellData(sheetname, 0, testStartRowNum).equals("LoginTest")) {
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
}
