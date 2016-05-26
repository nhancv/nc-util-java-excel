import java.io.File;
import java.util.ArrayList;

/**
 * Created by nhancao on 5/26/16.
 */
public class FileUtils {
    private File file;

    public FileUtils(String path) {
        file = new File(path);
    }

    public static String getExtension(String path) {
        int dot = path.lastIndexOf('.');
        return path.substring(dot + 1);
    }

    public String getExtension() {
        int dot = file.getPath().lastIndexOf('.');
        return file.getPath().substring(dot + 1);
    }

    public ArrayList<File> getSubFiles() {
        File[] listOfFiles = file.listFiles();
        ArrayList<File> list = new ArrayList<File>();
        if (listOfFiles != null) {
            for (File item : listOfFiles) {
                if (item.isFile() && (getExtension(item.getPath()).contains("xlsx") || getExtension(item.getPath()).contains("xls"))) {
                    list.add(item);
                }
            }
        }
        return list;
    }

    public File getFile() {
        return file;
    }
}
