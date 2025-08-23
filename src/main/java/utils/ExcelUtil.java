package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<Map<String, String>> getData(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Map<String, String> rowData = new HashMap<>();
                Row row = sheet.getRow(i);
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    rowData.put(headerRow.getCell(j).getStringCellValue(),
                                row.getCell(j).getStringCellValue());
                }
                data.add(rowData);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }
        return data;
    }


}
