package agenda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsável por realizar testes unitários na classe Agenda.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class AgendaTest {

    private Agenda agenda;
    private Telefone[] telefones;

    /**
     * Cria uma agenda para cada teste.
     */
    @Before
    public void criaAgenda(){
        this.agenda = new Agenda();
        this.telefones = new Telefone[3];
        this.telefones[0] = new Telefone(55, 83, "4444-4444", Telefone.CELULAR);
    }

    /**
     * Teste se um contato é cadastrado com sucesso.
     */
    @Test
    public void testCadastraContato() {
        boolean sucesso = this.agenda.cadastraContato(50, "Maria", "Rita", this.telefones, Contato.AMIGAO);
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição limite inicial.
     * Limite inicial da posição 1.
     */
    @Test
    public void testCadastraContatoPosicaoLimiteInicial(){
        boolean sucesso = this.agenda.cadastraContato(1, "Caetano", "Veloso", this.telefones, Contato.AMIGAO);
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição limite final.
     * Limite da posição 100.
     */
    @Test
    public void testCadastraContatoPosicaoLimiteFinal(){
        boolean sucesso = this.agenda.cadastraContato(100, "Raul", "Seixas", this.telefones, Contato.DISTANTE);
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição negativa.
     * Limite da posição de 1 a 100.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testCadastraContatoPosicaoInvalidaNegativa(){
        this.agenda.cadastraContato(-1, "Roberto", "Carlos", this.telefones, Contato.IRMAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição acima do limite.
     * Limite da posição de 1 a 100.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testCadastraContatoPosicaoInvalidaAcimaLimite(){
        this.agenda.cadastraContato(101, "Elis", "Regina", this.telefones, Contato.COLEGA);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com nome "nulo".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoNomeNulo(){
        this.agenda.cadastraContato(5, null, "Regina", this.telefones, Contato.IRMAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com nome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoNomeVazio(){
        this.agenda.cadastraContato(5, "", "Regina", this.telefones, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com sobrenome "nulo".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoSobrenomeNulo(){
        this.agenda.cadastraContato(5, "Elis", null, this.telefones, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com sobrenome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoSobrenomeVazio(){
        this.agenda.cadastraContato(5, "Elis", "", this.telefones, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com telefones "nulos".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefoneNulo(){
        this.agenda.cadastraContato(5, "Elis", "Regina", null, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato sem nenhum telefone.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefonesVazio(){
        this.agenda.cadastraContato(5, "Elis", "Regina",  new Telefone[3], Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com telefone nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefonesComTelefoneNulo(){
        telefones = new Telefone[3];
        telefones[0] = new Telefone(55, 83, null, Telefone.CELULAR);
        this.agenda.cadastraContato(5, "Elis", "Regina",  telefones, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com telefone vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefonesComTelefoneVazio(){
        telefones = new Telefone[3];
        telefones[0] = new Telefone(55, 83, "", Telefone.CELULAR);
        this.agenda.cadastraContato(5, "Elis", "Regina",  telefones, Contato.AMIGAO);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com nível de amizade inválido. É considerado válido nível de
     * amizade de 1 a 5.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoNivelAmizadeInvalido(){
        this.agenda.cadastraContato(5, null, "Regina", this.telefones, 6);
    }

    /**
     * Verifica se a localização do contato pela posição na agenda está correta.
     */
    @Test
    public void testLocalizaContatoPorPosicao(){
        String contato = "Chico Buarque - +55 (83) 4444-4444 [CELULAR]";
        this.agenda.cadastraContato(7, "Chico", "Buarque", this.telefones, Contato.AMIGAO);

        Assert.assertEquals(contato, this.agenda.localizaContato(7));
    }

    /**
     * Verifica se ocorre erro ao localizar um contato pela posição onde não existe contato cadastrado.
     * Limite da posição de 1 a 100.
     */
    @Test  (expected = NullPointerException.class)
    public void testLocalizaContatoNaoExistente(){
        this.agenda.cadastraContato(7, "Chico", "Buarque", this.telefones, Contato.AMIGAO);
        this.agenda.localizaContato(10);
    }

    /**
     * Verifica se ocorre erro ao localizar um contato por uma posição negativa.
     * Limite da posição de 1 a 100.
     */
    @Test  (expected = IndexOutOfBoundsException.class)
    public void testLocalizaContatoPosicaoInvalidaNegativa(){
        this.agenda.localizaContato(-1);
    }

    /**
     * Verifica se ocorre erro ao localizar um contato por uma posição acima do limite.
     * Limite da posição de 1 a 100.
     */
    @Test  (expected = IndexOutOfBoundsException.class)
    public void testLocalizaContatoPosicaoInvalidaAcimaLimite(){
        this.agenda.localizaContato(101);
    }

    /**
     * Verifica se um contato foi substituído por outro caso cadastrado na mesma posição.
     */
    @Test
    public void testCadastraContatoPosicaoExistente(){
        this.agenda.cadastraContato(7, "Oswaldo", "Montenegro", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(7, "Chico", "Buarque", this.telefones, Contato.AMIGAO);

        String contato = "Chico Buarque - +55 (83) 4444-4444 [CELULAR]";
        Assert.assertEquals(contato, this.agenda.localizaContato(7));
    }

    /**
     * Verifica se a listagem de todos os contatos da agenda na ordem de índice está correta.
     */
    @Test
    public void testListaContatos(){
        this.agenda.cadastraContato(10, "Milton", "Nascimento", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Renato", "Russo", this.telefones, Contato.AMIGAO);

        String listagem = "10 - Milton Nascimento" + System.lineSeparator() + "20 - Renato Russo" + System.lineSeparator();
        Assert.assertEquals(listagem, this.agenda.listaContato());
    }

    /**
     * Verifica se a pesquisa por nome completo através de uma palavra-chave está correta.
     */
    @Test
    public void testPesquisaContatoNomeCompleto(){
        this.agenda.cadastraContato(10, "Elba", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Zé", "Ramalho", this.telefones, Contato.AMIGAO);

        String busca = "10 - Elba Ramalho" + System.lineSeparator() + "20 - Zé Ramalho" + System.lineSeparator();
        Assert.assertEquals(busca, this.agenda.pesquisaNomeCompleto("Ramalho"));
    }

    /**
     * Verifica se ocorre erro ao buscar contatos com palavra-chave vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPesquisaContatoNomeCompletoPalavraChaveVazio(){
        this.agenda.pesquisaNomeCompleto("");
    }

    /**
     * Verifica se ocorre erro ao buscar contatos com palavra-chave nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPesquisaContatoNomeCompletoPalavraChaveNull(){
        this.agenda.pesquisaNomeCompleto(null);
    }

    /**
     * Verifica se a pesquisa por nome completo através de uma palavra-chave está correta.
     */
    @Test
    public void testBuscaContato(){
        this.agenda.cadastraContato(10, "Elba", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Zé", "Ramalho", this.telefones, Contato.AMIGAO);

        String busca = "10 - Elba Ramalho - +55 (83) 4444-4444 [CELULAR]" + System.lineSeparator();
        Assert.assertEquals(busca, this.agenda.buscaContato("Elba"));
    }

    /**
     * Verifica se ocorre erro ao buscar contatos com palavra-chave vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBuscaContatoPorNomeVazio(){
        this.agenda.buscaContato("");
    }

    /**
     * Verifica se ocorre erro ao buscar contatos com palavra-chave nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testBuscaContatoPorNomeNulo(){
        this.agenda.cadastraContato(10, "Elba", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Zé", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.pesquisaNomeCompleto(null);
    }

    /**
     * Verifica se a listagem de contatos por nível de amizado está correta.
     */
    @Test
    public void testListaPorNivelAmizade(){
        this.agenda.cadastraContato(10, "Elba", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Zé", "Ramalho", this.telefones, Contato.COLEGA);

        String busca = "10 - Elba Ramalho" + System.lineSeparator();
        Assert.assertEquals(busca, this.agenda.listaContatoPorNivelAmizade(Contato.AMIGAO));
    }

    /**
     * Verifica se ocorre erro ao listar contatos por nível de amizade inválido. Um nível de amizade válido é de 1 a 5.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testListaPorNivelAmizadeInvalido(){
        this.agenda.listaContatoPorNivelAmizade(10);
    }

    /**
     * Verifica se a contabilização da quantidade de contatos por nível de amizado está correta.
     */
    @Test
    public void testConsultaQuantidadePorNivelAmizade(){
        this.agenda.cadastraContato(10, "Elba", "Ramalho", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Zé", "Ramalho", this.telefones, Contato.AMIGAO);

        Assert.assertEquals(2, this.agenda.consultaQuantidadePorNivelAmizade(Contato.AMIGAO));
    }

    /**
     * Verifica se ocorre erro ao contabilização da quantidade de contatos por nível de amizade inválido.
     * Um nível de amizade válido é de 1 a 5.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConsultaQuantidadePorNivelAmizadeInvalido(){
        this.agenda.consultaQuantidadePorNivelAmizade(10);
    }

    /**
     * Verifica se a média de amizade dos contatos da agenda.
     * Obs.: Talvez o teste falhe devido o S.O ser pt-br o que aceita "," como separado decimal.
     */
    @Test
    public void testConsultaMediaAmizade(){
        this.agenda.cadastraContato(10, "Milton", "Nascimento", this.telefones, Contato.AMIGAO);
        this.agenda.cadastraContato(20, "Renato", "Russo", this.telefones, Contato.AMIGAO);

        String contatos = "Distante: 0,0 contato(s)." + System.lineSeparator() + "Colega: 0,0 contato(s)." +
                System.lineSeparator() + "Amigo: 0,0 contato(s)." + System.lineSeparator() + "Amigão: 1,0 contato(s)." +
                System.lineSeparator() + "Irmão: 0,0 contato(s)." + System.lineSeparator();
        Assert.assertEquals(contatos, this.agenda.listaMediasAmizade());
    }
}
