package agenda;

/**
 * Classe Agenda responsável por gerenciar Contato da agenda.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class Contato {
    /**
     * Primeiro nome do contato
     */
    private String nome;
    /**
     * Sobrenome do contato.
     */
    private String sobrenome;
    /**
     * Número de telefone.
     */
    private String telefone;

    /**
     * Construtor principal do objeto contato.
     * @param nome Primeiro nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Número do telefone.
     */
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

    /**
     * Retorna o nome completo do contato, ou seja, nome e sobrenome.
     * @return Nome completo (nome e sobrenome)
     */
    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }
}
