import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by nhancao on 5/26/16.
 */
public interface Handle {
    void compareFile(Workbook workbook) throws Exception;
}
