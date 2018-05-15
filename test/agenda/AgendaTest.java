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

    /**
     * Cria uma agenda a cada teste.
     */
    @Before
    public void criaAgenda(){
        this.agenda = new Agenda();
    }

    /**
     * Teste se um contato é cadastrado com sucesso.
     */
    @Test
    public void testCadastraContato(){
        boolean sucesso = this.agenda.cadastraContato(50, "Maria", "Rita", "(83) 4444-4444");
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição limite inicial.
     * Limite inicial da posição 1.
     */
    @Test
    public void testCadastraContatoPosicaoLimiteInicial(){
        boolean sucesso = this.agenda.cadastraContato(1, "Caetano", "Veloso", "(83) 7777-7777");
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição limite final.
     * Limite da posição 100.
     */
    @Test
    public void testCadastraContatoPosicaoLimiteFinal(){
        boolean sucesso = this.agenda.cadastraContato(100, "Raul", "Seixas", "(83) 6666-6666");
        Assert.assertTrue(sucesso);
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição negativa.
     * Limite da posição de 1 a 100.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testCadastraContatoPosicaoInvalidaNegativa(){
        this.agenda.cadastraContato(-1, "Roberto", "Carlos", "(83) 2222-2222");
    }

    /**
     * Verifica se ocorre erro quando inserido contato na posição acima do limite.
     * Limite da posição de 1 a 100.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testCadastraContatoPosicaoInvalidaAcimaLimite(){
        this.agenda.cadastraContato(101, "Elis", "Regina", "(83) 1111-1111");
    }

    /**
     * Verifica se ocorre erro quando inserido contato com nome "nulo".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoNomeNulo(){
        this.agenda.cadastraContato(5, null, "Regina", "(83) 1111-1111");
    }

    /**
     * Verifica se ocorre erro quando inserido contato com nome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoNomeVazio(){
        this.agenda.cadastraContato(5, "", "Regina", "(83) 1111-1111");
    }

    /**
     * Verifica se ocorre erro quando inserido contato com sobrenome "nulo".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoSobrenomeNulo(){
        this.agenda.cadastraContato(5, "Elis", null, "(83) 1111-1111");
    }

    /**
     * Verifica se ocorre erro quando inserido contato com sobrenome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoSobrenomeVazio(){
        this.agenda.cadastraContato(5, "Elis", "", "(83) 1111-1111");
    }

    /**
     * Verifica se ocorre erro quando inserido contato com telefone "nulo".
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefoneNulo(){
        this.agenda.cadastraContato(5, "Elis", "Regina", null);
    }

    /**
     * Verifica se ocorre erro quando inserido contato com telefone vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraContatoTelefoneVazio(){
        this.agenda.cadastraContato(5, "Elis", "Regina", "");
    }

    /**
     * Verifica se a localização do contato pela posição na agenda está correta.
     */
    @Test
    public void testLocalizaContatoPorPosicao(){
        String contato = "Chico Buarque - (83) 2323-2323";
        this.agenda.cadastraContato(7, "Chico", "Buarque", "(83) 2323-2323");

        Assert.assertEquals(contato, this.agenda.localizaContato(7));
    }

    /**
     * Verifica se ocorre erro ao localizar um contato pela posição onde não existe contato cadastrado.
     * Limite da posição de 1 a 100.
     */
    @Test  (expected = NullPointerException.class)
    public void testLocalizaContatoNaoExistente(){
        this.agenda.cadastraContato(7, "Chico", "Buarque", "(83) 2323-2323");
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
        this.agenda.cadastraContato(7, "Oswaldo", "Montenegro", "(83) 8888-8888");
        this.agenda.cadastraContato(7, "Chico", "Buarque", "(83) 2323-2323");

        String contato = "Chico Buarque - (83) 2323-2323";
        Assert.assertEquals(contato, this.agenda.localizaContato(7));
    }

    /**
     * Verifica se a listagem de todos os contatos da agenda na ordem de índice está correta.
     */
    @Test
    public void testListaContatos(){
        this.agenda.cadastraContato(10, "Milton", "Nascimento", "(83) 8888-8888");
        this.agenda.cadastraContato(20, "Renato", "Russo", "(83) 2323-2323");

        String listagem = "10 - Milton Nascimento" + System.lineSeparator() + "20 - Renato Russo" + System.lineSeparator();
        Assert.assertEquals(listagem, this.agenda.listaContato());
    }
}
