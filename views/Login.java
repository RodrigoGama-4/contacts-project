package views;

import Model.Contato;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {

    //PANELS
    protected JPanel pnlForm;
    protected JPanel pnlBaixo;

    //LABELS AND TEXT FROM ADD CONTACT
    protected JLabel lblnome;
    protected JTextField txtnome;

    
    protected JLabel lblnum;
    protected JTextField txtnum;

    
    protected JLabel lblemail;
    protected JTextField txtemail;

    public Login(){
        this.start();
    }

    private void start(){
        this.setTitle("ADICIONAR CONTATOS");
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);


        this.getContentPane().add(getpnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getpnlBaixo(), BorderLayout.PAGE_END);
        this.pack();
        
    }

    public JPanel getpnlForm(){
        if(pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4, 2));

            lblnome = new JLabel("Nome: ");
            txtnome = new JTextField(15);

            lblnum = new JLabel("Número: ");
            txtnum = new JTextField(15);

            lblemail = new JLabel("Email: ");
            txtemail = new JTextField(15);

            adicionarElementos(lblnome, txtnome);
            adicionarElementos(lblnum, txtnum);
            adicionarElementos(lblemail, txtemail); 
        }
        return pnlForm;
    }

    private void adicionarElementos(JLabel label_1, JTextField campo_texto){
        pnlForm.add(label_1);
        pnlForm.add(campo_texto);
    }
    
    private void fecharJanela(){
        this.setVisible(false);
        this.dispose();
    }

    private void limparTexto(){
        txtnome.setText(" ");
        txtnum.setText("");
        txtemail.setText("");
    }

    public JPanel getpnlBaixo(){
        //INSTANCIO USUARIO PADRAO
        Usuario usuario_padrao = new Usuario();

        if (pnlBaixo == null){
            this.pnlBaixo = new JPanel(new FlowLayout(FlowLayout.CENTER));

            //BOTAO LIMPAR OS DADOS
            JButton botao_limpar = new JButton("LIMPAR");
            pnlBaixo.add(botao_limpar);

            botao_limpar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   limparTexto();

                }
            });
        
            //BOTAO PARA FECHAR A PAGINA
            JButton botao_fechar = new JButton("FECHAR");
            pnlBaixo.add(botao_fechar);

            botao_fechar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   fecharJanela();
                   usuario_padrao.listaContato();
            
                }     
            });

            //BOTAO PARA ADICIONAR OS CONTATOS
            JButton botao_entrar = new JButton("ADICIONAR");
            pnlBaixo.add(botao_entrar);

            botao_entrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String regex_celular = "^\\d{9}$";
                    String regex_nome = "^[a-zA-Z]+$";

                    if (txtnum.getText().matches(regex_celular)) {
                        if (txtnome.getText().matches(regex_nome))
                            usuario_padrao.addContato(new Contato(txtnome.getText(), txtnum.getText(), txtemail.getText()));
                            System.out.println("ADICIONADO COM SUCESSO");
                            limparTexto();
                    }
                }
            });
        }
        return pnlBaixo;
    }    
}
