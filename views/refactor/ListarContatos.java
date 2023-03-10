package views.refactor;

import javax.swing.*;
import java.awt.*;



public class ListarContatos extends JFrame {
  
  //PANELS
  public FormPanel panelForm;
  public ActionsPanel actionsPanel;

  public ListarContatos() {
    Container container = this.getContentPane();
    panelForm = new FormPanel();
    actionsPanel = new ActionsPanel(panelForm);

    container.setLayout(new BorderLayout());
    container.add(panelForm.panel, BorderLayout.CENTER);
    container.add(actionsPanel.panel, BorderLayout.PAGE_END);
  
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.pack();
  }

  public void fecharJanela(){
    this.setVisible(false);
    this.dispose();
  }
}
