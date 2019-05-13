
package atividade9.entidade;

/**
 *
 * @author Marco Sena
 */
public class Estoque {
    
    private int codigoDoEstoque;
    private String nome;
    private String descricao;
    private double valor;
    private String emai;

    public Estoque() {
    }

    public Estoque(int codigoDoEstoque, String nome, String descricao, double valor, String emai) {
        this.codigoDoEstoque = codigoDoEstoque;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.emai = emai;
    }

    public int getCodigoDoEstoque() {
        return codigoDoEstoque;
    }

    public void setCodigoDoEstoque(int codigoDoEstoque) {
        this.codigoDoEstoque = codigoDoEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    @Override
    public String toString() {
        return "Estoque{" + "codigoDoEstoque: " + codigoDoEstoque + ", nome: " + nome 
                + ", descricao: " + descricao + ", valor: " + valor + ", emai: " + emai + '}';
    }
    
}
