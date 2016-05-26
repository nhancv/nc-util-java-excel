import java.awt.*;

/**
 * Created by nhancao on 5/26/16.
 */
public class Home {


    public static void main( String[] args ) throws Exception
    {
        FromGUI dialog = new FromGUI();
        dialog.setTitle("Excel Utils");
        dialog.pack();
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - dialog.getWidth()) / 2;
        final int y = (screenSize.height - dialog.getHeight()) / 2;
        dialog.setLocation(x, y);
        dialog.setVisible(true);
        System.exit(0);

    }
}
