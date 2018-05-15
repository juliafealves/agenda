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
    private Telefone[] telefones;

    /**
     * Construtor principal do objeto contato.
     *
     * @param nome Primeiro nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefones Telefones de um contato podendo no máximo ter 3.
     */
    public Contato(String nome, String sobrenome, Telefone[] telefones) {
        this.nome = nome;
        this.sobrenome = sobrenome;

        this.telefones = new Telefone[3];
        this.telefones = telefones;
    }

    /**
     * Retorna o contato formatado como "Nome Sobrenome - Telefone".
     *
     * Exemplo: Roberto Carlos - (82) 8888-88888
     * @return String
     */
    public String toString(){
        String telefones = "";

        for(Telefone telefone: this.telefones){
            if(telefone != null){
                telefones += telefone.toString() + " ";
            }
        }

        return this.nome + " " + this.sobrenome + " - " + telefones.trim();
    }

    /**
     * Retorna o nome completo do contato, ou seja, nome e sobrenome.
     * @return Nome completo (nome e sobrenome)
     */
    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }
}
