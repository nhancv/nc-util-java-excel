import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by nhancao on 5/26/16.
 */
public class GuiOutputStream extends OutputStream {
    private JTextArea textArea;

    public GuiOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char) b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}