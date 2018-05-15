package agenda;

import java.util.Arrays;

/**
 * Classe Agenda responsável por gerenciar Contato da agenda.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class Contato {
    /**
     * Níveis de amizades
     */
    public static final int DISTANTE = 1;
    public static final int COLEGA = 2;
    public static final int AMIGO = 3;
    public static final int AMIGAO = 4;
    public static final int IRMAO = 5;

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
     * Nível de amizade
     */
    private int nivelAmizade;

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
     * Construtor secundário do objeto contato com adicional de nível de amizade.
     *
     * @param nome Primeiro nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefones Telefones de um contato podendo no máximo ter 3.
     * @param nivelAmizade Nível de amizade 1: distante, 2: colega, 3: amigo, 4: amigão, 5: irmão.
     */
    public Contato(String nome, String sobrenome, Telefone[] telefones, int nivelAmizade) {
        this(nome, sobrenome, telefones);
        this.nivelAmizade = nivelAmizade;
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

    /**
     * Retorna o primeiro nome do contato.
     * @return
     */
    public String getNome() {
        return this.nome;
    }
}
