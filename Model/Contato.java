package Model;

public class Contato implements Comparable<Contato>{
    private String nome_amigo;
    private String numero_celular;
    private String email;

    public Contato(String nome_amigo, String numero_celular, String email) {
        this.nome_amigo = nome_amigo;
        this.numero_celular = numero_celular;
        this.email = email;
    }

    public String getNome_amigo() {
        return nome_amigo;
    }

    public void setNome_amigo(String nome_amigo) {
        this.nome_amigo = nome_amigo;
    }

    public String getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(String numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String result;
        
        result = String.format("Nome:   %s\n", this.nome_amigo) +
                String.format("Número:   %s\n", this.numero_celular) +
                String.format("Email:   %s\n", this.email);
        
        return(result);
    }

    @Override
    public int compareTo(Contato o) {
        return this.nome_amigo.compareTo(o.getNome_amigo());
    }
}
