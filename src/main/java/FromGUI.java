import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FromGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonClose;
    private JTextArea txtLog;

    public FromGUI() {
        PrintStream printStream = new PrintStream(new GuiOutputStream(txtLog));
        // keeps reference of standard output stream
        System.setOut(printStream);
        System.setErr(printStream);

        setContentPane(contentPane);
        setModal(true);
        this.setSize(500, 700);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        new Thread(new Runnable() {
            public void run() {
                String intro = "EXCEL UTIL\nExcel matching first column\nAuthor: Nhan Cao\nEmail: caovannhan2002@gmail.com";
                System.out.println(intro);
                System.out.println("-Begin-");
                Conf config = null;
                try {
                    config = new Gson().fromJson(new InputStreamReader(new FileInputStream(Conf.cfgFilePath)), Conf.class);
                    System.out.println("Root file: " + config._rootFileName);
                    config.refreshRootPath();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    new ExcelUtils(Conf.rootFilePath, new HandleImpl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("-Complete-");
            }
        }).start();

    }

    private void onClose() {
        dispose();
    }
}
