package Model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Usuario {
    ArrayList <Contato> contatos = new ArrayList<>();
    

    public void addContato(Contato contato) {
        contatos.add(contato);
        System.out.println("CONTATO ADICIONADO COM SUCESSO");
        //ORDENA OS CONTATOS
        Collections.sort(contatos);
    }
   
    public void removerContato(String nome) {
        for (int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getNome_amigo().equals(nome)){
                contatos.remove(i);
                System.out.println("CONTATO REMOVIDO COM SUCESSO");
            }
        }
    }

    public int getQuantidadeContatos(){
        return contatos.size();
    }

    //CRIA UM ARQUIVO DE TEXTO COM OS CONTATOS
    public void listaContato() {
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
