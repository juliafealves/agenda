package agenda;

/**
 * Classe Agenda responsável por gerenciar todos os contatos.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class Agenda {
    /**
     * Todos os contatos "salvos" na agenda.
     */
    private Contato[] contatos;

    /**
     * Contrutor principal do objeto Agenda. Inicializa com espaço para 100 contatos.
     */
    public Agenda(){
        contatos = new Contato[100];
    }

    /**
     * Cadastra os dados do contato. Para isto é necessário indicar a posição na agenda onde se deseja cadastradar,
     * o nome e o telefone é obrigatório no cadastro de um contato.
     * Um posição válida está entre 1 a 100. Caso indique uma posição já utilizada a mesma será substituída pela última
     * cadastrada.
     *
     * @param posicao Posição que será guardado o contato na agenda. Varia de 1 até 100.
     * @param nome Primeiro nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefones Número do telefone do contato
     * @param nivelAmizade Nível de amizade 1: distante, 2: colega, 3: amigo, 4: amigão, 5: irmão.
     * @return boolean Retorna o valor booleano "true" em caso de sucesso.
     */
    public boolean cadastraContato(int posicao, String nome, String sobrenome, Telefone[] telefones, int nivelAmizade) {
        if(posicao < 1 || posicao > 100 )
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");

        if(nome == null || nome.isEmpty() || sobrenome == null || sobrenome.isEmpty())
            throw new IllegalArgumentException("Nome e/ou sobrenome inválidos.");

        if(!this.validaTelefones(telefones))
            throw new IllegalArgumentException("Necessário cadastrar ao menos um telefone.");

        if(nivelAmizade < 1 || nivelAmizade > 5)
            throw new IllegalArgumentException("Nível de amizade inválido.");

        contatos[--posicao] = new Contato(nome, sobrenome, telefones, nivelAmizade);

        return true;
    }

    /**
     * Localiza um contato na agenda pela posição. Uma posição válida está entre 1 a 100, caso informado uma
     * posição inválida será lançada uma exceção.
     *
     * @param posicao Posição do contato na agenda.
     * @return Contato Retorna o contato informa caso exista, caso contrário é lançada uma excecão.
     */
    public String localizaContato(int posicao) {
        if(posicao < 1 || posicao > 100 )
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");

        posicao -= 1;

        if(this.contatos[posicao] == null)
            throw new NullPointerException("Não existe contato na posição informada.");

        return this.contatos[posicao].toString();
    }

    /**
     * Lista todos os contatos cadastrado na agenda. Formatado seguindo o exemplo abaixo:
     * 1 - Ouvidoria UFCG
     * 2 - Coordenacao Computacao UFCG
     * 10 - MC Pedrinho
     * 22 - Fabio Morais
     * @return Todos os contatos cadastrados na agenda em ordem de posição
     */
    public String listaContato() {
        String contatos = "";

        for(int i = 0; i < this.contatos.length; i++){
            if(this.contatos[i] != null){
                contatos += (i + 1) + " - " + this.contatos[i].getNomeCompleto() + System.lineSeparator();
            }
        }

        return contatos;
    }

    /**
     * Verifica se um telefone foi adicionado ao contato. Deverá existir ao menos um telefone cadastrado.
     *
     * @param telefones
     * @return
     */
    private boolean validaTelefones(Telefone[] telefones){
        if(telefones == null) return false;

        for(Telefone telefone: telefones){
            if(telefone != null) return true;
        }

        return false;
    }

    /**
     * Retorna todos os contatos que contenha alguma parte da palavra-chave.
     * Busca pelo nome e sobrenome.
     *
     * @param palavraChave Palavra-chave a ser localizada.
     * @return
     */
    public String pesquisaNomeCompleto(String palavraChave) {
        if(palavraChave == null || palavraChave.isEmpty())
            throw new IllegalArgumentException("Informe uma palavra-chave válida.");

        String contatos = "";

        for(int i = 0; i < this.contatos.length; i++){
            if(this.contatos[i] != null && this.contatos[i].getNomeCompleto().contains(palavraChave)){
                contatos += (i + 1) + " - " + this.contatos[i].getNomeCompleto() + System.lineSeparator();
            }
        }

        return contatos;
    }

    /**
     * Busca um contato pelo nome.
     * @param nome
     * @return
     */
    public String buscaContato(String nome) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Informe um nome válido.");

        for(int i = 0; i < this.contatos.length; i++){
            if(this.contatos[i] != null && this.contatos[i].getNome().equals(nome)){
                return  (i + 1) + " - " + this.contatos[i].toString() + System.lineSeparator();
            }
        }

        return "";
    }

    /**
     * Lista todos os contatos de um nível de amizade específico.
     * @param nivelAmizade Nível de amizade 1: distante, 2: colega, 3: amigo, 4: amigão, 5: irmão.
     *
     * @return
     */
    public String listaContatoPorNivelAmizade(int nivelAmizade) {
        if(nivelAmizade < 1 || nivelAmizade > 5)
            throw new IllegalArgumentException("Nível de amizade inválido.");

        String contatos = "";

        for(int i = 0; i < this.contatos.length; i++){
            if(this.contatos[i] != null && this.contatos[i].getNivelAmizade() == nivelAmizade){
                contatos += (i + 1) + " - " + this.contatos[i].getNomeCompleto() + System.lineSeparator();
            }
        }

        return contatos;
    }

    /**
     * Contabiliza a quantidade de contatos com determinado nível de amizade.
     *
     * @param nivelAmizade Nível de amizade 1: distante, 2: colega, 3: amigo, 4: amigão, 5: irmão.
     * @return
     */
    public int consultaQuantidadePorNivelAmizade(int nivelAmizade) {
        if(nivelAmizade < 1 || nivelAmizade > 5)
            throw new IllegalArgumentException("Nível de amizade inválido.");

        int quantidade = 0;

        for(Contato contato: this.contatos){
            if(contato != null && contato.getNivelAmizade() == nivelAmizade){
                quantidade++;
            }
        }

        return quantidade;
    }

    /**
     * Retona as médias de amizade dos contatos.
     * @return
     */
    public String listaMediasAmizade() {
        String medias = "";
        int totalContatos = 0;

        for(Contato contato: this.contatos){
            if(contato != null)
                totalContatos++;
        }

        for(int nivel = 1; nivel <= 5; nivel++){
            String media = "0,0";

            if(totalContatos > 0)
                media = String.format("%.1f", (float) this.consultaQuantidadePorNivelAmizade(nivel)/totalContatos);

            medias += Contato.obterNivelAmizade(nivel) + ": " + media + " contato(s)." + System.lineSeparator();
        }

        return medias;
    }
}
