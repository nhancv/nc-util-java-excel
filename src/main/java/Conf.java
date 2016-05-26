import com.google.gson.annotations.SerializedName;

/**
 * Created by nhancao on 5/26/16.
 */
public class Conf {
    public static String rootFolder = "files";
    public static String subFolder = "files/sub";
    public static String rootFileName = "root.xlsx";
    public static String rootFilePath = rootFolder + "/" + rootFileName;
    public static String cfgFilePath = "files/config.json";

    @SerializedName("root_file_name")
    public String _rootFileName;

    public void refreshRootPath() {
        rootFileName = _rootFileName;
        rootFilePath = rootFolder + "/" + rootFileName;
    }
}
