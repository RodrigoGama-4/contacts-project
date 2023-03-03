package views;

import javax.swing.SwingUtilities;

public class App{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            Login login = new Login();
            login.setVisible(true);
        }
        );
    }

        
}