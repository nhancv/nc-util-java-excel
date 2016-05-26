/**
 * Created by nhancao on 5/26/16.
 */
public class Home {


    public static void main( String[] args ) throws Exception
    {
        System.out.println("hello");
        new ExcelUtils(Conf.rootFilePath, new HandleImpl());
        System.out.println("complete");


    }
}
