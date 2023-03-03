package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListarContatos extends JFrame {
  
  //PANELS
  public FormPanel panelForm;

  public ListarContatos() {
    Container container = this.getContentPane();
    panelForm = new FormPanel();  

    container.setLayout(new BorderLayout());
    container.add(panelForm.panel, BorderLayout.CENTER);
    // container.add(getpnlBaixo(), BorderLayout.PAGE_END);
  
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.pack();
  }

  public void fecharJanela(){
    this.setVisible(false);
    this.dispose();
  }
}
