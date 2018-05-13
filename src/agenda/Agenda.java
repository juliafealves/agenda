package agenda;

/**
 * Classe Agenda responsável por gerenciar todos os contatos.
 */
public class Agenda {
    /**
     * Lista com todos os contatos "salvos" na agenda.
     */
    private Contato[] contatos;

    public Agenda(){
        contatos = new Contato[100];
    }

    /**
     * Cadastra os dados do contato.
     *
     * @param posicao Posição que será guardado o contato na agenda. Varia de 1 até 100.
     * @param nome Primeiro nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Número do telefone do contato
     * @return boolean Retorna o valor booleano "true" em caso de sucesso.
     */
    public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        if(posicao < 1 || posicao > 100 )
            throw new IndexOutOfBoundsException("Posição inválida");

        if(nome == null || nome.isEmpty() || sobrenome == null || sobrenome.isEmpty())
            throw new IllegalArgumentException("Nome e/ou sobrenome inválidos.");

        if(telefone == null || telefone.isEmpty())
            throw new IllegalArgumentException("Telefone inválido.");

        contatos[--posicao] = new Contato(nome, sobrenome, telefone);

        return true;
    }

    /**
     * Localiza um contato na agenda pela posição. Uma posição válida está entre 1 a 100, caso informado uma
     * posição inválida será lançada uma exceção.
     *
     * @param posicao Posição do contato na agenda.
     * @return Contato Retorna o contato informa caso exista, caso contrário é lançada uma excecão.
     */
    public Contato localizaContato(int posicao) {
        if(posicao < 1 || posicao > 100 )
            throw new IndexOutOfBoundsException("Posição inválida");

        posicao -= 1;

        if(this.contatos[posicao] == null)
            throw new NullPointerException("Não existe contato na posição informada.");

        return this.contatos[posicao];
    }
}
