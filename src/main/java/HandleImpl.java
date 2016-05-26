import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by nhancao on 5/26/16.
 */
public class HandleImpl implements Handle {

    public void compareFile(Workbook workbook, File file) throws Exception {
        final Sheet sheet = workbook.getSheetAt(0);
        final CellStyle cellStyleMatch = workbook.createCellStyle();
        cellStyleMatch.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        cellStyleMatch.setFillPattern(CellStyle.SOLID_FOREGROUND);
        
        FileUtils fileUtils = new FileUtils(Conf.subFolder);
        ArrayList<File> subFiles = fileUtils.getSubFiles();
        for (File item : subFiles) {
            System.out.println("Process: " + item.getPath());
            new ExcelUtils(item.getPath(), new Handle() {
                public void compareFile(Workbook workbook, File file) throws Exception {
                    Sheet subSheet = workbook.getSheetAt(0);
                    final CellStyle subCellStyleMatch = workbook.createCellStyle();
                    subCellStyleMatch.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    subCellStyleMatch.setFillPattern(CellStyle.SOLID_FOREGROUND);
                    for (Row subRow : subSheet) {
                        Cell subCell = subRow.getCell(0);
                        for (Row row : sheet) {
                            Cell cell = row.getCell(0);
                            if (getCellValue(subCell).toUpperCase().equals(getCellValue(cell).toUpperCase())) {
                                subCell.setCellStyle(subCellStyleMatch);
                                cell.setCellStyle(cellStyleMatch);
                            }
                        }
                    }
                    workbook.write(new FileOutputStream(file));
                }
            });
        }

        workbook.write(new FileOutputStream(file));

    }

    public String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue() + "";
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue() + "";
            default:
                return "";
        }
    }
}
