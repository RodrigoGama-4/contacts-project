package views;

import javax.swing.SwingUtilities;

public class App{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            ListarContatos login = new ListarContatos();
            login.setVisible(true);
        }
        );
    }

        
}
