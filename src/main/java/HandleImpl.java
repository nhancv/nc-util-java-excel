import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by nhancao on 5/26/16.
 */
public class HandleImpl implements Handle {

    public void comparefile(Sheet sheet) {
        Cell cell = null;
        //Update the value of cell
        cell = sheet.getRow(1).getCell(0);
        cell.setCellValue("nhancv");
        cell = sheet.getRow(2).getCell(0);
        cell.setCellValue("nhancv");
        cell = sheet.getRow(3).getCell(0);
        cell.setCellValue("nhancv");
    }
}
