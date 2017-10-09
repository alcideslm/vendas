package vend.model;

/**
 *
 * @author Alcides Lemos
 */
public class Produto {
    private int cod;
    private String  descricao,
                    nome;
    private double valor;
    int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    @Override
    public String toString() {
        return "Cod:" + cod + " - " + nome + "\tValor Unit.: R$ " + valor + 
                "\nQuantidade: " + quantidade + "\tValor Total: R$ " + 
                (valor * quantidade) + "\nDescricao:" + descricao;
    }
    
    
}
