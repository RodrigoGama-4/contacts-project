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

    protected JLabel lblprocurar;
    protected JTextField txtprocurar;


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

            lblprocurar = new JLabel("Procurar contato");
            txtprocurar = new JTextField(15);

            pnlForm.add(lblnome);
            pnlForm.add(txtnome);

            pnlForm.add(lblnum);
            pnlForm.add(txtnum);

            pnlForm.add(lblemail);
            pnlForm.add(txtemail);

            pnlForm.add(lblprocurar);
            pnlForm.add(txtprocurar);
           
        }
        return pnlForm;
    }
    
    public void fecharJanela(){
        this.setVisible(false);
        this.dispose();
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
                   txtnome.setText(" ");
                   txtnum.setText("");
                   txtemail.setText("");

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
                    usuario_padrao.addContato(new Contato(txtnome.getText(), txtnum.getText(), txtemail.getText()));
                    System.out.println("ADICIONADO COM SUCESSO");

                    txtnome.setText(" ");
                    txtnum.setText("");
                    txtemail.setText("");
                }
            });
        }
        return pnlBaixo;
    }    
}
