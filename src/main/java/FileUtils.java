import java.io.File;

/**
 * Created by nhancao on 5/26/16.
 */
public class FileUtils {
    private File file;

    public FileUtils(String path) {
        file = new File(path);
    }

    public String getExtension() {
        int dot = file.getPath().lastIndexOf('.');
        return file.getPath().substring(dot + 1);
    }

    public String getExtension(String path) {
        int dot = path.lastIndexOf('.');
        return path.substring(dot + 1);
    }

    public File[] getSubFiles() {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    System.out.println("File " + listOfFile.getName() + " - ext: " + getExtension(listOfFile.getPath()));
                }
            }
            return listOfFiles;
        }
        return new File[]{};
    }

    public File getFile() {
        return file;
    }
}
