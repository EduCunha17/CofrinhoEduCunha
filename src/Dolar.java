/**
 * Classe que representa a moeda Dólar Americano (USD).
 * Esta classe estende a classe abstrata Moeda e implementa os métodos
 * abstratos info() e converter() com a lógica específica para Dólar.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public class Dolar extends Moeda {
    
    /**
     * Taxa de câmbio do Dólar para Real.
     * Valor fixo: 1 Dólar = 5.44 Reais
     */
    private static final double TAXA_CAMBIO_DOLAR = 5.44;
    
    /**
     * Construtor da classe Dolar.
     * Chama o construtor da classe pai (Moeda) para inicializar o valor.
     * 
     * @param quantiaDolar O valor em dólares a ser armazenado
     */
    public Dolar(double quantiaDolar) {
        super(quantiaDolar);
    }
    
    /**
     * Implementação do método abstrato info().
     * Retorna uma descrição formatada da moeda Dólar.
     * 
     * @return String com informações sobre a moeda Dólar
     */
    @Override
    public String info() {
        return String.format("Dólar - Valor: USD %.2f", valorMoeda);
    }
    
    /**
     * Implementação do método abstrato converter().
     * Converte o valor em dólares para reais usando a taxa de câmbio.
     * 
     * @return O valor convertido para Real (BRL)
     */
    @Override
    public double converter() {
        return valorMoeda * TAXA_CAMBIO_DOLAR;
    }
    
    /**
     * Método toString para representação textual do objeto.
     * Útil para exibição e depuração.
     * 
     * @return String representando o objeto Dolar
     */
    @Override
    public String toString() {
        return info() + " (Equivale a R$ " + String.format("%.2f", converter()) + ")";
    }
}

