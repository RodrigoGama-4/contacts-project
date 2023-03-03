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

public class ActionsPanel {
  public JPanel panel;
  public Usuario usuario;
  public Map<String, List<Function<ActionEvent, ?>>> buttonHandlers;

  public ActionsPanel() {
    usuario = new Usuario();
    panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    List<String> nomes = Arrays.asList("LIMPAR", "FECHAR", "ADICIONAR");
    List<Function<ActionEvent, ?>> funcoes = {
      (e -> e),
      (e -> {}),
      (e -> {})
    };
    for (int i=0; i<nomes.size(); i++) {
      Entry<JLabel, JTextField> pair = new SimpleEntry<>(nome, );
      JButton btn = new JButton(nome);
    }
  }
}
