package agenda;

import org.junit.*;

/**
 * Classe responsável por realizar testes unitários na classe Contato.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class ContatoTest {

    private Contato contato;

    /**
     * Cria um objeto do tipo Contato para ser utilizado nos casos de testes.
     */
    @Before
    public void criaContato(){
        this.contato = new Contato("Roberto", "Carlos", "(88) 6565-6565");
    }

    /**
     * Verifica se cria um objeto.
     */
    @Test
    public void testContato() {
        new Contato("Elis", "Regina", "2222-5852");
    }

    /**
     * Verifica se o toString está formato corretamente, com nome sobrenome e telefone.
     */
    @Test
    public void testToString(){
        String toString = "Roberto Carlos - (88) 6565-6565";
        Assert.assertEquals(toString, this.contato.toString());
    }

    /**
     * Verifica retorna o nome completo do contato e se está formato corretamente, com nome sobrenome.
     */
    @Test
    public void testNomeCompleto(){
        String toString = "Roberto Carlos";
        Assert.assertEquals(toString, this.contato.getNomeCompleto());
    }
}
