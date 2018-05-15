package agenda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsável por realizar testes unitários na classe Telefone.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class TelefoneTest {
    private Telefone telefone;

    /**
     * Cria um telefone para cada teste.
     */
    @Before
    public void criaTelefone(){
        this.telefone = new Telefone(55, 83, "9898-8585", Telefone.TRABALHO);
    }

    /**
     * Verifica se um telefone foi criado com sucesso.
     */
    @Test
    public void testTelefone(){
        new Telefone(55, 83, "33398895");
    }

    /**
     * Verifica se um telefone com tipo associado foi criado com sucesso.
     */
    @Test
    public void testTelefoneComTipo(){
        new Telefone(55, 83, "3339-8895", Telefone.CASA);
    }

    /**
     * Verifica se um telefone foi criado com sucesso.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testTelefoneNumeroVazio(){
        new Telefone(55, 83, "");
    }

    /**
     * Verifica se um telefone foi criado com sucesso.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testTelefoneNumeroNulo(){
        new Telefone(55, 83, null);
    }

    /**
     * Verifica se o toString está formato corretamente, com código do país, ddd telefone e tipo de telefone.
     */
    @Test
    public void testToString(){
        String contato = "+55 (83) 9898-8585 [TRABALHO]";
        Assert.assertEquals(contato, this.telefone.toString());
    }
}
