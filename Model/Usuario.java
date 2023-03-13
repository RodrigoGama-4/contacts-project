package Model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import views.AdiconarCont;


public class Usuario {
    ArrayList <Contato> contatos = new ArrayList<>();

    private AdiconarCont classeAdiconarCont;

    public Usuario(AdiconarCont classeAdicionar){
        this.classeAdiconarCont = classeAdicionar;
    }



    public void addContato(Contato contato) {
        String regex_celular = "^\\d{9}$";
        Pattern pattern = Pattern.compile(regex_celular);
        Matcher matcher = pattern.matcher(contato.getNumero_celular());
        if (matcher.matches()){
            contatos.add(contato);
            System.out.println("CONTATO ADICIONADO COM SUCESSO");
            classeAdiconarCont.limparCampoTexto();
            classeAdiconarCont.aumentarTela();
        }    
    }

    public void removerContato(String nome) {
        for (int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getNome_amigo().equals(nome)){
                contatos.remove(i);
                System.out.println("CONTATO REMOVIDO COM SUCESSO");
            }
            else if(contatos.size() < 1){
                System.out.println("Você não tem contatos adicionados");
            }
        }
    }

    public int getQuantidadeContatos(){
        return contatos.size();
    }

    //CRIA UM ARQUIVO DE TEXTO COM OS CONTATOS
    public void salvarContatos() {
        try {
            FileWriter writer = new FileWriter("lista_de_pessoas.txt");
            for(Contato item: contatos){
                writer.write(item.toString() + "\n");
            }
            writer.close();
    
        } catch (Exception e) {
            System.out.println("moio");
        }
    }

    public void procurarContato(String nome){
        for (int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getNome_amigo().equals(nome)){
                System.out.println(contatos.get(i).toString());
            }
        }
    }
   
    public void mudarContatoNumero(String numeroAntigo, String numero){
        for(Contato item: contatos){
            if (item.getNumero_celular().equals(numeroAntigo)){
                item.setNumero_celular(numero);
            }
        }
        System.out.println("O numero" + numeroAntigo + "foi alterado com sucesso para " + numero);
    }

    
    public void mudarContatoNome(String nomeAntigo, String nome){
        for(Contato item: contatos){
            if (item.getNome_amigo().equals(nomeAntigo)){
                item.setNumero_celular(nome);
            }
        }
        System.out.println("O nome" + nomeAntigo + "foi alterado com sucesso para " + nome);
    }

    public void mudarContatoEmail(String emailAntigo, String email){
        for(Contato item: contatos){
            if (item.getEmail().equals(emailAntigo)){
                item.setNumero_celular(email);
            }
        }
        System.out.println("O email" + emailAntigo + "foi alterado com sucesso para " + email);
    }

    public int getQuantidade() {
        return contatos.size();
    }
}
