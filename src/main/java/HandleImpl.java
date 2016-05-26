import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by nhancao on 5/26/16.
 */
public class HandleImpl implements Handle {

    static Row row;

    public void compareFile(Sheet sheet) {
        for (Row aSheet : sheet) {
            row = aSheet;
            Cell cell = row.getCell(0);
            cell.setCellValue("nhancv");
        }
    }
}
