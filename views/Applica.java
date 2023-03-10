package views;

import javax.swing.SwingUtilities;

public class Applica{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            AdiconarCont login = new AdiconarCont();
            login.setVisible(true);
        }
        );
    }

}
