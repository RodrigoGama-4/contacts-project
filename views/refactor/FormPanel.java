package views.refactor;

import javax.swing.*;
import java.awt.*;


import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;


public class FormPanel {
  public JPanel panel;
  // dicionário de <id, (label, campo de texto)>
  public Map<String, Map.Entry<JLabel, JTextField>> entries;

  public FormPanel() {
    panel = new JPanel(new GridLayout(4, 2));
    entries = new HashMap<>();

    ArrayList<String> fields = new ArrayList<>(
      Arrays.asList("Nome", "Número", "E-mail")
    );
    for (String campo : fields) {
      JLabel rotulo = new JLabel(campo);
      JTextField campoDeTexto = new JTextField(15);
      Entry<JLabel, JTextField> pair = new SimpleEntry<>(rotulo, campoDeTexto);
      entries.put(campo, pair); // chave, valor
      panel.add(rotulo);
      panel.add(campoDeTexto);
    }
  }
  public void limparTexto() {
    for (JTextField txtField : getTextFields()) {
      txtField.setText("");
    }
  }
  public ArrayList<JTextField> getTextFields() {
    ArrayList<JTextField> fields = new ArrayList<>();
    for (Entry<JLabel, JTextField> field : entries.values()) {
      fields.add(field.getValue());
    }
    // return fields.toArray(JTextField[]);
    return fields;
  }
}
