package agenda;

public class Telefone {
    public final static int CELULAR = 1;
    public final static int TRABALHO = 2;
    public final static int CASA = 3;

    private int codigoPais;
    private int ddd;
    private String telefone;
    private int tipo;


    /**
     * Método principal
     * @param codigoPais Código do País
     * @param ddd DDD do Estado.
     * @param telefone Número do telefone
     */
    public Telefone(int codigoPais, int ddd, String telefone) {
        if(telefone == null || telefone.equals(""))
            throw new IllegalArgumentException("Telefone inválido.");

        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    /**
     * Construtor secundário, permite adicionar um tipo ao telefone.
     * @param codigoPais Código do País
     * @param ddd DDD do Estado.
     * @param telefone Número do telefone
     * @param tipo Tipo do telefone 1: "CELULAR", 2: "TRABALHO", 3: "CASA".
     */
    public Telefone(int codigoPais, int ddd, String telefone, int tipo) {
        this(codigoPais, ddd, telefone);
        this.tipo = tipo;
    }

    /**
     * Retorna a representação textual do telefone no formato:
     * +55 (83) 9898-8585 [TRABALHO]
     * @return
     */
    public String toString(){
        return "+" + this.codigoPais + " (" + this.ddd + ") " + this.telefone + " [" + this.getTipo() + "]";
    }

    /**
     * Retorna o tipo do telefone.
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
