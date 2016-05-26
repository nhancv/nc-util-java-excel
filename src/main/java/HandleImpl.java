import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by nhancao on 5/26/16.
 */
public class HandleImpl implements Handle {

    static Row row;

    public void compareFile(Workbook workbook) throws Exception {
        Sheet sheet = workbook.getSheetAt(0);

        FileUtils fileUtils = new FileUtils(Conf.subFolder);
        ArrayList<File> subFiles = fileUtils.getSubFiles();
        for (final File item : subFiles) {
            System.out.println(item.getPath());
            new ExcelUtils(item.getPath(), new Handle() {
                public void compareFile(Workbook workbook) throws Exception {
                    Sheet sheet = workbook.getSheetAt(0);
                    Cell cell = sheet.getRow(0).getCell(0);
                    cell.setCellValue("nhancv");
                    workbook.write(new FileOutputStream(item));
                }
            });
        }

        for (Row aSheet : sheet) {
            row = aSheet;
            Cell cell = row.getCell(0);
            cell.setCellValue("nhancv");
        }
        FileOutputStream outFile = new FileOutputStream(new File(Conf.outFilePath));
        workbook.write(outFile);
        outFile.close();
    }
}
