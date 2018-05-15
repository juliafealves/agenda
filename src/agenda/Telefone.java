package agenda;

public class Telefone {
    public final static int CELULAR = 1;
    public final static int TRABALHO = 2;
    public final static int CASA = 3;

    private int codigoPais;
    private int ddd;
    private String numero;
    private int tipo;


    /**
     * Método principal
     * @param codigoPais Código do País
     * @param ddd DDD do Estado.
     * @param numero Número do numero
     */
    public Telefone(int codigoPais, int ddd, String numero) {
        if(numero == null || numero.equals(""))
            throw new IllegalArgumentException("Telefone inválido.");

        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.numero = numero;
    }

    /**
     * Construtor secundário, permite adicionar um tipo ao numero.
     * @param codigoPais Código do País
     * @param ddd DDD do Estado.
     * @param numero Número do numero
     * @param tipo Tipo do telefone 1: "CELULAR", 2: "TRABALHO", 3: "CASA".
     */
    public Telefone(int codigoPais, int ddd, String numero, int tipo) {
        this(codigoPais, ddd, numero);
        this.tipo = tipo;
    }

    /**
     * Retorna a representação textual do numero no formato:
     * +55 (83) 9898-8585 [TRABALHO]
     * @return
     */
    public String toString(){
        return "+" + this.codigoPais + " (" + this.ddd + ") " + this.numero + " [" + this.getTipo() + "]";
    }

    /**
     * Retorna o tipo do numero.
     * @return
     */
    private String getTipo(){
        if(this.tipo == CASA){
            return "CASA";
        } else if(this.tipo == TRABALHO){
            return "TRABALHO";
        } else if(this.tipo == CELULAR){
            return "CELULAR";
        }

        return "SEM TIPO";
    }
}
