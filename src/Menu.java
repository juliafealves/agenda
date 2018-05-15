import agenda.Agenda;

import java.util.Scanner;

/**
 * Classe Menu responsável por gerenciar uma agenda de contatos. Permitindo cadastrar, exibir e listar.
 * @author Júlia Fernandes Alves 117211383 <julia.alves@ccc.ufcg.edu.br>
 */
public class Menu {

    private static Agenda agenda;

    /**
     * Método principal para execução do programa. Existe as seguintes opções:
     * (C)adastrar Contato - Cadastra um contato na agenda.
     * (L)istar Contatos - Lista todos os contatos de uma agenda.
     * (E)xibir Contato - Exibe um contato da agenda.
     * (S)air - Para Sair do programa.
     *
     * Os caracteres entre parenteses indicam a opção a ser escolhida. Ou seja, se digitar C é a opção escolhida
     * para Cadastrar Contato.
     *
     * @param args
     */
    public static void main(String[] args){
        agenda = new Agenda();

        String opcao = "";
        Scanner scanner = new Scanner(System.in);

        do{
            Menu.exibeMenu();
            opcao = scanner.next().toUpperCase();

            if(opcao.equals("C")){
                Menu.cadastraContato(scanner);
            }else if(opcao.equals("L")){
                Menu.listaContatos();
            }else if(opcao.equals("E")){
                Menu.exibeContato(scanner);
            } else if(!opcao.equals("S")) {
                System.out.println("OPÇÃO INVÁLIDA!");
            }

        } while (!opcao.equals("S"));
    }

    /**
     * Exibe os dados de um contato pela posição.
     * Exemplo:
     * Contato> 1
     *
     * Ouvidoria UFCG - (83) 21011585
     *
     * @param scanner Scanner
     */
    private static void exibeContato(Scanner scanner) {
        try{
            System.out.print("Contato: ");
            int posicao = scanner.nextInt();
            System.out.println(agenda.localizaContato(posicao));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Lista todos os contatos da agenda, caso não existe exibe uma notificação para o usuário.
     * Exemplo:
     * Opção> L
     *
     * 1 - Ouvidoria UFCG
     * 2 - Coordenacao Computacao UFCG
     * 10 - MC Pedrinho
     * 22 - Fabio Morais
     */
    private static void listaContatos() {
        String contatos = agenda.listaContato();

        if (!contatos.isEmpty()){
            System.out.println(contatos);
        } else{
            System.out.println("Nenhum contato cadastrado na agenda.");
        }
    }

    /**
     * Cadastra um contato na agenda.
     * @param scanner Scanner
     */
    private static void cadastraContato(Scanner scanner) {
        try{
            System.out.print("Posição: ");
            int posicao = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine().trim();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine().trim();

            if (agenda.cadastraContato(posicao,nome, sobrenome, telefone)){
                System.out.println("CADASTRO REALIZADO!");
            }
        }catch (Exception exception){
            System.out.println("CADASTRO INVÁLIDO: " + exception.getMessage());
        }
    }

    /**
     *  Exibe no console todas as opções de menu disponíveis.
     * Exemplo:
     * Opção> E
     * Contato> 1
     *
     * Ouvidoria UFCG - (83) 21011585
     */
    private static void exibeMenu(){
        String menu = System.lineSeparator();
        String[] opcoes = {"(C)adastrar Contato", "(L)istar Contatos", "(E)xibir Contato", "(S)air"};

        for(String opcao: opcoes){
            menu += opcao + System.lineSeparator();
        }

        menu += System.lineSeparator() + "Opção> ";

        System.out.print(menu);
    }
}
