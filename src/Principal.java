import java.util.Scanner;

/**
 * Classe principal que contém o método main e o menu interativo do sistema.
 * Esta classe gerencia a interação com o usuário e coordena as operações
 * do cofrinho de moedas, demonstrando o uso de herança e polimorfismo.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public class Principal {
    
    /**
     * Método principal que inicia a execução do programa.
     * Cria uma instância do cofrinho e exibe o menu de opções.
     * 
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Cria uma instância do cofrinho para armazenar as moedas
        Cofrinho meuCofrinho = new Cofrinho();
        
        // Scanner para ler entrada do usuário
        Scanner leitorEntrada = new Scanner(System.in);
        
        // Variável para controlar o loop do menu
        int opcaoSelecionada;
        
        // Loop principal do menu - continua até o usuário escolher sair (opção 0)
        do {
            exibirMenu();
            
            try {
                // Lê a opção escolhida pelo usuário
                opcaoSelecionada = leitorEntrada.nextInt();
                leitorEntrada.nextLine(); // Limpa o buffer do scanner
                
                // Processa a opção selecionada
                processarOpcao(opcaoSelecionada, meuCofrinho, leitorEntrada);
                
            } catch (Exception excecao) {
                // Trata erros de entrada inválida
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                leitorEntrada.nextLine(); // Limpa o buffer em caso de erro
                opcaoSelecionada = -1; // Define um valor diferente de 0 para continuar o loop
            }
        } while (opcaoSelecionada != 0);
        
        // Fecha o scanner ao finalizar o programa
        leitorEntrada.close();
        System.out.println("Programa encerrado. Obrigado por usar o Cofrinho de Moedas!");
    }
    
    /**
     * Exibe o menu de opções disponíveis para o usuário.
     * O menu é formatado de forma clara e organizada.
     */
    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("    COFRINHO DE MOEDAS");
        System.out.println("========================================");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total convertido para Real");
        System.out.println("0 - Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
    }
    
    /**
     * Processa a opção selecionada pelo usuário e executa a ação correspondente.
     * Utiliza um switch para direcionar para a função apropriada.
     * 
     * @param opcao A opção selecionada pelo usuário
     * @param cofrinhoReferencia Referência ao objeto Cofrinho
     * @param scannerEntrada Scanner para leitura de entrada do usuário
     */
    private static void processarOpcao(int opcao, Cofrinho cofrinhoReferencia, Scanner scannerEntrada) {
        switch (opcao) {
            case 1:
                adicionarMoeda(cofrinhoReferencia, scannerEntrada);
                break;
            case 2:
                removerMoeda(cofrinhoReferencia, scannerEntrada);
                break;
            case 3:
                listarMoedas(cofrinhoReferencia);
                break;
            case 4:
                calcularTotal(cofrinhoReferencia);
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida! Por favor, escolha uma opção entre 0 e 4.");
        }
    }
    
    /**
     * Adiciona uma nova moeda ao cofrinho.
     * Solicita ao usuário o tipo de moeda e o valor, demonstrando polimorfismo
     * ao criar instâncias de diferentes subclasses de Moeda.
     * 
     * @param cofrinhoReferencia Referência ao objeto Cofrinho
     * @param scannerEntrada Scanner para leitura de entrada
     */
    private static void adicionarMoeda(Cofrinho cofrinhoReferencia, Scanner scannerEntrada) {
        System.out.println("\n--- Adicionar Moeda ---");
        System.out.println("Escolha o tipo de moeda:");
        System.out.println("1 - Dólar (USD)");
        System.out.println("2 - Euro (EUR)");
        System.out.println("3 - Real (BRL)");
        System.out.print("Opção: ");
        
        try {
            int tipoMoeda = scannerEntrada.nextInt();
            scannerEntrada.nextLine(); // Limpa o buffer
            
            System.out.print("Digite o valor da moeda: ");
            double valorDigitado = scannerEntrada.nextDouble();
            scannerEntrada.nextLine(); // Limpa o buffer
            
            // Cria a moeda apropriada baseada na escolha do usuário
            // Demonstra polimorfismo: diferentes tipos de moedas são tratados uniformemente
            Moeda novaMoeda = null;
            
            switch (tipoMoeda) {
                case 1:
                    novaMoeda = new Dolar(valorDigitado);
                    break;
                case 2:
                    novaMoeda = new Euro(valorDigitado);
                    break;
                case 3:
                    novaMoeda = new Real(valorDigitado);
                    break;
                default:
                    System.out.println("Tipo de moeda inválido!");
                    return;
            }
            
            // Adiciona a moeda ao cofrinho (polimorfismo em ação)
            cofrinhoReferencia.adicionar(novaMoeda);
            
        } catch (Exception excecao) {
            System.out.println("Erro ao adicionar moeda: " + excecao.getMessage());
            scannerEntrada.nextLine(); // Limpa o buffer em caso de erro
        }
    }
    
    /**
     * Remove uma moeda do cofrinho.
     * Solicita ao usuário o tipo e valor da moeda a ser removida.
     * 
     * @param cofrinhoReferencia Referência ao objeto Cofrinho
     * @param scannerEntrada Scanner para leitura de entrada
     */
    private static void removerMoeda(Cofrinho cofrinhoReferencia, Scanner scannerEntrada) {
        if (cofrinhoReferencia.estaVazio()) {
            System.out.println("\nO cofrinho está vazio. Não há moedas para remover.");
            return;
        }
        
        System.out.println("\n--- Remover Moeda ---");
        System.out.println("Escolha o tipo de moeda:");
        System.out.println("1 - Dólar (USD)");
        System.out.println("2 - Euro (EUR)");
        System.out.println("3 - Real (BRL)");
        System.out.print("Opção: ");
        
        try {
            int tipoMoeda = scannerEntrada.nextInt();
            scannerEntrada.nextLine(); // Limpa o buffer
            
            System.out.print("Digite o valor da moeda a ser removida: ");
            double valorDigitado = scannerEntrada.nextDouble();
            scannerEntrada.nextLine(); // Limpa o buffer
            
            // Cria uma moeda temporária para comparação e remoção
            Moeda moedaParaRemover = null;
            
            switch (tipoMoeda) {
                case 1:
                    moedaParaRemover = new Dolar(valorDigitado);
                    break;
                case 2:
                    moedaParaRemover = new Euro(valorDigitado);
                    break;
                case 3:
                    moedaParaRemover = new Real(valorDigitado);
                    break;
                default:
                    System.out.println("Tipo de moeda inválido!");
                    return;
            }
            
            // Remove a moeda do cofrinho
            cofrinhoReferencia.remover(moedaParaRemover);
            
        } catch (Exception excecao) {
            System.out.println("Erro ao remover moeda: " + excecao.getMessage());
            scannerEntrada.nextLine(); // Limpa o buffer em caso de erro
        }
    }
    
    /**
     * Lista todas as moedas presentes no cofrinho.
     * Demonstra polimorfismo ao chamar o método info() de cada moeda,
     * que retorna informações específicas de acordo com o tipo real do objeto.
     * 
     * @param cofrinhoReferencia Referência ao objeto Cofrinho
     */
    private static void listarMoedas(Cofrinho cofrinhoReferencia) {
        System.out.println("\n--- Listagem de Moedas ---");
        System.out.println(cofrinhoReferencia.listagemMoedas());
    }
    
    /**
     * Calcula e exibe o total convertido para Real.
     * Demonstra polimorfismo ao chamar o método converter() de cada moeda,
     * que realiza a conversão específica de acordo com o tipo de moeda.
     * 
     * @param cofrinhoReferencia Referência ao objeto Cofrinho
     */
    private static void calcularTotal(Cofrinho cofrinhoReferencia) {
        System.out.println("\n--- Total Convertido para Real ---");
        
        if (cofrinhoReferencia.estaVazio()) {
            System.out.println("O cofrinho está vazio. Total: R$ 0,00");
        } else {
            double totalEmReais = cofrinhoReferencia.totalConvertido();
            System.out.printf("Total no cofrinho convertido para Real: R$ %.2f\n", totalEmReais);
            System.out.println("Quantidade de moedas: " + cofrinhoReferencia.quantidadeMoedas());
        }
    }
}

