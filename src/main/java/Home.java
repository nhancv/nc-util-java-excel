/**
 * Created by nhancao on 5/26/16.
 */
public class Home {


    public static void main( String[] args ) throws Exception
    {
        String intro = "EXCEL UTIL\nExcel matching first column\nAuthor: Nhan Cao\nEmail: caovannhan2002@gmail.com";
        System.out.println(intro);
        System.out.println("-Begin-");
        new ExcelUtils(Conf.rootFilePath, new HandleImpl());
        System.out.println("-Complete-");


    }
}
