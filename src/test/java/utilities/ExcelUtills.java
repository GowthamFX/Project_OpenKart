package utilities;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtills {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	public ExcelUtills(String path) 
	{
		this.path=path;
	}
	
	public int getRowCount(String xlsheet) throws IOException 
	{
		
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;	

	}
	
	public int getCellCount(String xlsheet,int rowNum) throws IOException 
	
	{
		
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		short cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	
	
	}
	
   public String getCellData(String xlsheet,int rowNum,int colNum) throws IOException 
	
	{
	    fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		String data;
		try
		{
			//data=cell.toString();
			DataFormatter formatter= new DataFormatter();
			data = formatter.formatCellValue(cell); //returns the formatted value of a cell as a string
			
			
		}
		catch (Exception e) {
			
			data="";
		}
		
		wb.close();
		fi.close();
	    return data;   
	   
	   
	}
   
   public void setCellData(String sheetName, int rownum, int column, String data) throws IOException {
	   
	   
	   File xlfile = new File(path);
	   
	    if (!xlfile.exists()) {  // If file not exists then create new file
	    	wb = new XSSFWorkbook();
	        fo = new FileOutputStream(path);
	        wb.write(fo);
	    }

	    fi = new FileInputStream(path);
	    wb = new XSSFWorkbook(fi);

	    if (wb.getSheetIndex(sheetName) == -1) { // If sheet not exists then create new Sheet
	    	wb.createSheet(sheetName);
	    }
	    ws = wb.getSheet(sheetName);

	    if (ws.getRow(rownum) == null) { // If row not exists then create new Row
	    	ws.createRow(rownum);
	    }
	    row = ws.getRow(rownum);

	    cell = row.createCell(column);
	    cell.setCellValue(data);

	    fo = new FileOutputStream(path);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	}
   
   
   public void fillGreenColour(String xlsheet,int rowNum,int colNum) throws IOException 
   
   {
	    fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
   }
   
   
public static void fillRedColour(String xlfile,String xlsheet,int rowNum,int colNum) throws IOException 
   
   {
	    fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
			   
	   
	   
   }
   
	
}


