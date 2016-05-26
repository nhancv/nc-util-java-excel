/**
 * Created by nhancao on 5/26/16.
 */
public class Home {


    public static void main( String[] args ) throws Exception
    {
        System.out.println("hello");
        new ExcelUtils(new HandleImpl());
//        FileUtils fileUtils = new FileUtils(Conf.subFolder);
//        fileUtils.getSubFiles();

        System.out.println("complete");


    }
}
