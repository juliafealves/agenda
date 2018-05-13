package agenda;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;

    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    /**
     * Retorna o contato formatado como "Nome Sobrenome - Telefone".
     *
     * Exemplo: Roberto Carlos - (82) 8888-88888
     * @return String
     */
    public String toString(){
        return this.nome + " " + this.sobrenome + " - " + this.telefone;
    }
}
