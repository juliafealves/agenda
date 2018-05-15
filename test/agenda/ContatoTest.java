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
        Telefone[] telefones = new Telefone[3];
        telefones[0] = new Telefone(55, 88, "6565-9898", Telefone.TRABALHO);
        telefones[1] = new Telefone(55, 88, "3333-8888", Telefone.CELULAR);
        this.contato = new Contato("Roberto", "Carlos", telefones);
    }

    /**
     * Verifica se cria um objeto.
     */
    @Test
    public void testContato() {
        Telefone[] telefones = new Telefone[3];
        telefones[0] = new Telefone(55, 88, "6565-9898", Telefone.TRABALHO);
        new Contato("Elis", "Regina", telefones);
    }

    /**
     * Verifica se o toString está formato corretamente, com nome sobrenome e telefone.
     */
    @Test
    public void testToString(){
        String toString = "Roberto Carlos - +55 (88) 6565-9898 [TRABALHO] +55 (88) 3333-8888 [CELULAR]";
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
