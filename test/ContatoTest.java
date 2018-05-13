import agenda.Contato;
import org.junit.*;

public class ContatoTest {

    private Contato contato;

    @Before
    public void criaObjeto(){
        this.contato = new Contato("Roberto", "Carlos", "(88) 6565-6565");
    }

    @Test
    public void testContato() {
        new Contato("Julia", "Fernandes", "2222-5852");
    }

    @Test
    public void testToString(){
        String toString = "Roberto Carlos - (88) 6565-6565";
        Assert.assertEquals(toString, this.contato.toString());
    }

}
