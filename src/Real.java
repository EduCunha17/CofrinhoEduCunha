/**
 * Classe que representa a moeda Real Brasileiro (BRL).
 * Esta classe estende a classe abstrata Moeda e implementa os métodos
 * abstratos info() e converter() com a lógica específica para Real.
 * Como o Real já é a moeda base, a conversão retorna o próprio valor.
 * 
 * @author Eduardo Ferreira da Cunha
 * @version 1.0
 */
public class Real extends Moeda {
    
    /**
     * Construtor da classe Real.
     * Chama o construtor da classe pai (Moeda) para inicializar o valor.
     * 
     * @param quantiaReal O valor em reais a ser armazenado
     */
    public Real(double quantiaReal) {
        super(quantiaReal);
    }
    
    /**
     * Implementação do método abstrato info().
     * Retorna uma descrição formatada da moeda Real.
     * 
     * @return String com informações sobre a moeda Real
     */
    @Override
    public String info() {
        return String.format("Real - Valor: BRL %.2f", valorMoeda);
    }
    
    /**
     * Implementação do método abstrato converter().
     * Como o Real já é a moeda base, não há necessidade de conversão.
     * Retorna o próprio valor sem alterações.
     * 
     * @return O valor em Real (sem conversão)
     */
    @Override
    public double converter() {
        return valorMoeda;
    }
    
    /**
     * Método toString para representação textual do objeto.
     * Útil para exibição e depuração.
     * 
     * @return String representando o objeto Real
     */
    @Override
    public String toString() {
        return info();
    }
}

