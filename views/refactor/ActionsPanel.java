package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Usuario;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.*;
import views.IBtnAction;
import Model.Contato;

public class ActionsPanel {
  public JPanel panel;
  public Usuario usuario;
  public Map<String, IBtnAction[]> buttonHandlers;
  public FormPanel formPanel;

  public ActionsPanel(FormPanel formPanel) {
    this.formPanel = formPanel;
    usuario = new Usuario();
    panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    List<String> nomes = Arrays.asList("LIMPAR", "FECHAR", "ADICIONAR");
    IBtnAction a = () -> {
      formPanel.limparTexto();
    };
    IBtnAction b = () -> {
      // parent.fecharJanela
      usuario.listaContato();
    };
    IBtnAction c = () -> {
      String regex_celular = "^\\d{9}$";
      String regex_nome = "^[a-zA-Z]+$";
      JTextField txtNome = formPanel.entries.get("Nome").getValue();
      JTextField txtNum = formPanel.entries.get("Número").getValue();
      JTextField txtEmail = formPanel.entries.get("E-mail").getValue();

      if (txtNum.getText().matches(regex_celular)) {
        if (txtNome.getText().matches(regex_nome))
          usuario.addContato(new Contato(
              txtNome.getText(),
              txtNum.getText(),
              txtEmail.getText()
          ));
          System.out.println("ADICIONADO COM SUCESSO");
          formPanel.limparTexto();
    }};
    IBtnAction[] funcoes = {a, b, c};
    for (int i=0; i<nomes.size(); i++) {
      String nome = nomes.get(i);
      IBtnAction func = funcoes[i];
      // Entry<String, IBtnAction[]> pair = new SimpleEntry<>(nome, );
      JButton btn = new JButton(nome);
      panel.add(btn);
      btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            func.handleAction();
          }
      });
    }
  }
}