import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

/**
 * Created by nhancao on 5/26/16.
 */
public class ExcelUtils {

    FileUtils fileUtils;

    public ExcelUtils(String path, Handle handle) throws Exception {
        fileUtils = new FileUtils(path);
        Workbook workbook = WorkbookFactory.create(new FileInputStream(fileUtils.getFile()));
        handle.compareFile(workbook, fileUtils.getFile());
    }


}
