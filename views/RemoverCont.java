package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverCont extends JFrame{

    //PANELS
    protected JPanel pnlForm;
    protected JPanel pnlBaixo;

    public RemoverCont(){
        this.start();
    }

    private void fecharjanelaRC(){
        this.setVisible(false);
        this.dispose();
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

    private JPanel getpnlBaixo() {
        if (pnlBaixo == null){
            pnlBaixo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton botao_voltar = new JButton("VOLTAR");
            JButton botao_remover = new JButton("REMOVER");
            pnlBaixo.add(botao_voltar);
            pnlBaixo.add(botao_remover);

            //AÇÕES
            botao_voltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fecharjanelaRC();
                    //AdiconarCont login = new AdiconarCont();
                    //login.setVisible(true);
                }
            });
        }
        return pnlBaixo;
    }

    private JPanel getpnlForm() {
        if(pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4, 2));

            JLabel lblnome = new JLabel("Remover: ");
            JTextField txtnome = new JTextField(10);

            pnlForm.add(lblnome);
            pnlForm.add(txtnome);
        }
        return pnlForm;
    }

    /*public static void main(String[] args) {
        RemoverCont kkk = new RemoverCont();
        kkk.setVisible(true);
    }*/
}
