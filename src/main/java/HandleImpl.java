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
            try {
                new ExcelUtils(item.getPath(), new Handle() {
                    public void compareFile(Workbook workbook, File file) throws Exception {
                        Sheet subSheet = workbook.getSheetAt(0);
                        final CellStyle subCellStyleMatch = workbook.createCellStyle();
                        subCellStyleMatch.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        subCellStyleMatch.setFillPattern(CellStyle.SOLID_FOREGROUND);
                        for (Row subRow : subSheet) {
                            Cell subCell = subRow.getCell(0);
                            if (subCell != null) {
                                for (Row row : sheet) {
                                    Cell cell = row.getCell(Conf.rootColSel);
                                    if (cell != null) {
                                        String v1 = getCellValue(cell);
                                        String v2 = getCellValue(subCell);
                                        if (v1 != null && v2 != null && v1.trim().length() > 0 && v1.toUpperCase().equals(v2.toUpperCase())) {
                                            subCell.setCellStyle(subCellStyleMatch);
                                            cell.setCellStyle(cellStyleMatch);
                                        }
                                    }
                                }
                            }
                        }
                        workbook.write(new FileOutputStream(file));
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        workbook.write(new FileOutputStream(file));
    }

    public String getCellValue(Cell cell) {
        String cellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    cellValue = cell.getCellFormula();
                    break;

                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.getDateCellValue().toString();
                    } else {
                        cellValue = Double.toString(cell.getNumericCellValue());
                    }
                    break;

                case Cell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;

                case Cell.CELL_TYPE_BOOLEAN:
                    cellValue = Boolean.toString(cell.getBooleanCellValue());
                    break;
            }
        }
        return cellValue;
    }
}
