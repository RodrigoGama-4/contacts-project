package views;

import javax.swing.SwingUtilities;

public class App{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            AdiconarCont login = new AdiconarCont();
            login.setVisible(true);
        }
        );
    }
}