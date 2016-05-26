import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by nhancao on 5/26/16.
 */
public class ExcelUtils {

    FileUtils fileUtils;
    public ExcelUtils(String path, Handle handle) throws Exception {
        fileUtils = new FileUtils(Conf.rootFilePath);
        Workbook workbook = WorkbookFactory.create(new FileInputStream(fileUtils.getFile()));
        Sheet sheet = workbook.getSheetAt(0);
        handle.compareFile(sheet);
        FileOutputStream outFile = new FileOutputStream(new File("test_tmp.xls"));
        workbook.write(outFile);
        outFile.close();
    }


}
