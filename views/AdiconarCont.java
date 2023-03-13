package views;

import Model.Contato;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AdiconarCont extends JFrame {

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

    public AdiconarCont(){
        this.start();
    }

    private void start(){
        this.setTitle("ADICIONAR CONTATOS");
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(getpnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getpnlBaixo(), BorderLayout.PAGE_END);
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

    //Logo após a primeira adição de um contato a tela vai aumentar e mostrar o botao remover
    public void aumentarTela(){
        this.setSize(600, 200);
    }

    private void fecharJanela(){
        this.setVisible(false);
        this.dispose();
    }

    public void limparCampoTexto(){
        txtnome.setText("");
        txtnum.setText("");
        txtemail.setText("");
    }
 
    public JPanel getpnlBaixo(){
        //INSTANCIO USUARIO PADRAO
        Usuario usuario_padrao = new Usuario(this);


        if (pnlBaixo == null){
            this.pnlBaixo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            ArrayList<JButton> botoes = new ArrayList<JButton>();
            String nomesBotoes[] = {"LIMPAR", "FECHAR", "ADICIONAR", "REMOVER"};

            for (int i = 0; i<nomesBotoes.length; i++){
                JButton botoes_tela = new JButton(nomesBotoes[i]);
                pnlBaixo.add(botoes_tela);
                botoes.add(botoes_tela);
            }

            botoes.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   limparCampoTexto();

                }
            });

            botoes.get(1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   fecharJanela();
                   usuario_padrao.salvarContatos();
            
                }     
            });

            botoes.get(2).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                  
                    usuario_padrao.addContato(new Contato(txtnome.getText(), txtnum.getText(), txtemail.getText()));
                }
            });

            AdiconarCont retorneThis = this;
            botoes.get(3).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   if (usuario_padrao.getQuantidadeContatos() > 0){
                        RemoverCont view_removercont = new RemoverCont(usuario_padrao, retorneThis);
                        view_removercont.setVisible(true);  
                   }
                }     
            });
        }
        return pnlBaixo;
    }    
}
