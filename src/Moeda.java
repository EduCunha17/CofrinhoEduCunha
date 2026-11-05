/**
 * Classe abstrata que representa uma moeda genérica.
 * Esta classe serve como base para diferentes tipos de moedas (Dólar, Euro, Real).
 * Como é abstrata, não pode ser instanciada diretamente.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public abstract class Moeda {
    
    /**
     * Valor da moeda armazenado como número decimal de precisão dupla.
     * Este atributo armazena o valor nominal da moeda antes da conversão.
     */
    protected double valorMoeda;
    
    /**
     * Construtor da classe Moeda.
     * Inicializa o valor da moeda com o parâmetro fornecido.
     * 
     * @param valorInicial O valor inicial da moeda
     */
    public Moeda(double valorInicial) {
        this.valorMoeda = valorInicial;
    }
    
    /**
     * Método abstrato que deve ser implementado pelas classes filhas.
     * Retorna informações específicas sobre o tipo de moeda.
     * 
     * @return String contendo informações da moeda
     */
    public abstract String info();
    
    /**
     * Método abstrato que deve ser implementado pelas classes filhas.
     * Converte o valor da moeda para Real (BRL).
     * Cada tipo de moeda possui sua própria taxa de conversão.
     * 
     * @return O valor convertido para Real
     */
    public abstract double converter();
    
    /**
     * Método getter para obter o valor da moeda.
     * 
     * @return O valor atual da moeda
     */
    public double getValor() {
        return valorMoeda;
    }
    
    /**
     * Método setter para definir o valor da moeda.
     * 
     * @param novoValor O novo valor a ser atribuído
     */
    public void setValor(double novoValor) {
        this.valorMoeda = novoValor;
    }
}

