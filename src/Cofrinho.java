import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que representa um cofrinho (piggy bank) que armazena diferentes tipos de moedas.
 * Utiliza um ArrayList para armazenar objetos do tipo Moeda, demonstrando
 * o uso de polimorfismo, já que pode conter instâncias de Dolar, Euro ou Real.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public class Cofrinho {
    
    /**
     * Lista dinâmica que armazena todas as moedas adicionadas ao cofrinho.
     * Utiliza ArrayList para permitir adição e remoção flexível de elementos.
     * O tipo genérico Moeda permite armazenar qualquer subclasse (Dolar, Euro, Real).
     */
    private ArrayList<Moeda> colecaoMoedas;
    
    /**
     * Construtor da classe Cofrinho.
     * Inicializa o ArrayList vazio para armazenar as moedas.
     */
    public Cofrinho() {
        this.colecaoMoedas = new ArrayList<Moeda>();
    }
    
    /**
     * Adiciona uma moeda ao cofrinho.
     * Utiliza polimorfismo: aceita qualquer objeto que seja uma instância de Moeda
     * (Dolar, Euro, Real ou qualquer outra subclasse futura).
     * 
     * @param moedaParaAdicionar A moeda a ser adicionada ao cofrinho
     */
    public void adicionar(Moeda moedaParaAdicionar) {
        if (moedaParaAdicionar != null) {
            colecaoMoedas.add(moedaParaAdicionar);
            System.out.println("Moeda adicionada com sucesso!");
        } else {
            System.out.println("Erro: Não é possível adicionar uma moeda nula.");
        }
    }
    
    /**
     * Remove uma moeda específica do cofrinho.
     * Compara a moeda fornecida com as moedas existentes na lista.
     * Remove apenas a primeira ocorrência encontrada.
     * 
     * @param moedaParaRemover A moeda a ser removida do cofrinho
     * @return true se a moeda foi removida com sucesso, false caso contrário
     */
    public boolean remover(Moeda moedaParaRemover) {
        if (moedaParaRemover == null) {
            System.out.println("Erro: Não é possível remover uma moeda nula.");
            return false;
        }
        
        // Utiliza Iterator para percorrer e remover elementos com segurança
        Iterator<Moeda> iterador = colecaoMoedas.iterator();
        while (iterador.hasNext()) {
            Moeda moedaAtual = iterador.next();
            // Compara tipo e valor para identificar a moeda correta
            if (moedaAtual.getClass().equals(moedaParaRemover.getClass()) &&
                Math.abs(moedaAtual.getValor() - moedaParaRemover.getValor()) < 0.01) {
                iterador.remove();
                System.out.println("Moeda removida com sucesso!");
                return true;
            }
        }
        
        System.out.println("Moeda não encontrada no cofrinho.");
        return false;
    }
    
    /**
     * Lista todas as moedas presentes no cofrinho.
     * Utiliza polimorfismo ao chamar o método info() de cada moeda,
     * que será executado de acordo com o tipo real do objeto (Dolar, Euro ou Real).
     * 
     * @return String contendo a listagem de todas as moedas
     */
    public String listagemMoedas() {
        if (colecaoMoedas.isEmpty()) {
            return "O cofrinho está vazio.";
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== Moedas no Cofrinho ===\n");
        
        // Percorre todas as moedas e chama o método info() de cada uma
        // Demonstra polimorfismo: cada tipo de moeda exibe sua informação específica
        for (int indice = 0; indice < colecaoMoedas.size(); indice++) {
            Moeda moedaAtual = colecaoMoedas.get(indice);
            resultado.append((indice + 1) + ". " + moedaAtual.info() + "\n");
        }
        
        return resultado.toString();
    }
    
    /**
     * Calcula o valor total de todas as moedas convertidas para Real.
     * Utiliza polimorfismo ao chamar o método converter() de cada moeda,
     * que será executado de acordo com o tipo real do objeto.
     * 
     * @return O valor total convertido para Real (BRL)
     */
    public double totalConvertido() {
        double somaTotal = 0.0;
        
        // Itera sobre todas as moedas e soma os valores convertidos
        // Demonstra polimorfismo: cada moeda converte seu valor de forma específica
        for (Moeda moedaAtual : colecaoMoedas) {
            somaTotal += moedaAtual.converter();
        }
        
        return somaTotal;
    }
    
    /**
     * Retorna a quantidade de moedas armazenadas no cofrinho.
     * 
     * @return O número de moedas no cofrinho
     */
    public int quantidadeMoedas() {
        return colecaoMoedas.size();
    }
    
    /**
     * Verifica se o cofrinho está vazio.
     * 
     * @return true se o cofrinho estiver vazio, false caso contrário
     */
    public boolean estaVazio() {
        return colecaoMoedas.isEmpty();
    }
}

