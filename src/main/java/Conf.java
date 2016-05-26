import com.google.gson.annotations.SerializedName;

/**
 * Created by nhancao on 5/26/16.
 */
public class Conf {
    public static Integer rootColSel = 1;
    public static String rootFolder = "files";
    public static String subFolder = "files/sub";
    public static String rootFileName = "root.xls";
    public static String rootFilePath = rootFolder + "/" + rootFileName;
    public static String cfgFilePath = "files/config.json";

    @SerializedName("root_file_name")
    public String _rootFileName;
    @SerializedName("root_col_sel")
    public Integer _rootColSel;

    public void refreshRootPath() {
        rootFileName = _rootFileName;
        rootColSel = _rootColSel;
        rootFilePath = rootFolder + "/" + rootFileName;
    }
}
