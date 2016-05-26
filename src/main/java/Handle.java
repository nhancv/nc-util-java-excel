import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;

/**
 * Created by nhancao on 5/26/16.
 */
public interface Handle {
    void compareFile(Workbook workbook, File file) throws Exception;
}
