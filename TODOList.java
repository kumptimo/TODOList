package todolist;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class TODOList {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            try {
                showUI();
            } catch (IOException ex) {
                Logger.getLogger(TODOList.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private static void showUI() throws IOException {

        JFrame mainWindow = new JFrame("TODOList");
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI mainGUI = new GUI(mainWindow);
        mainGUI.setOpaque(true);
        mainWindow.setContentPane(mainGUI);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
