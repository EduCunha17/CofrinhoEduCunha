/**
 * Classe que representa a moeda Euro (EUR).
 * Esta classe estende a classe abstrata Moeda e implementa os métodos
 * abstratos info() e converter() com a lógica específica para Euro.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public class Euro extends Moeda {
    
    /**
     * Taxa de câmbio do Euro para Real.
     * Valor fixo: 1 Euro = 6.34 Reais
     */
    private static final double TAXA_CAMBIO_EURO = 6.34;
    
    /**
     * Construtor da classe Euro.
     * Chama o construtor da classe pai (Moeda) para inicializar o valor.
     * 
     * @param quantiaEuro O valor em euros a ser armazenado
     */
    public Euro(double quantiaEuro) {
        super(quantiaEuro);
    }
    
    /**
     * Implementação do método abstrato info().
     * Retorna uma descrição formatada da moeda Euro.
     * 
     * @return String com informações sobre a moeda Euro
     */
    @Override
    public String info() {
        return String.format("Euro - Valor: EUR %.2f", valorMoeda);
    }
    
    /**
     * Implementação do método abstrato converter().
     * Converte o valor em euros para reais usando a taxa de câmbio.
     * 
     * @return O valor convertido para Real (BRL)
     */
    @Override
    public double converter() {
        return valorMoeda * TAXA_CAMBIO_EURO;
    }
    
    /**
     * Método toString para representação textual do objeto.
     * Útil para exibição e depuração.
     * 
     * @return String representando o objeto Euro
     */
    @Override
    public String toString() {
        return info() + " (Equivale a R$ " + String.format("%.2f", converter()) + ")";
    }
}

