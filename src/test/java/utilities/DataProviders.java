package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	 // DataProvider 1
    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {
        
        String path = ".\\testData\\Test_Data_Driven.xlsx"; // Taking xl file from testData
        
        ExcelUtills xlutil = new ExcelUtills(path); // Creating an object for XLUtility
        
        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1",1);
        
        String logindata[][] = new String[totalrows][totalcols]; // Creating a two-dimensional array to store data
        
        for (int i = 1; i <= totalrows; i++) { // Read the data from xl and store in the array
            for (int j = 0; j < totalcols; j++) { // i is rows, j is columns
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Storing data in the array
            }
        }
        
        return logindata; // Returning two-dimensional array
    }
}

// DataProvider 2

// DataProvider 3

// DataProvider 4