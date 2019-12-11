package br.com.trabalhofinal.model;

import javax.persistence.*;

@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String produtos;
    private String medida;
    private Float preco;
    private int qtde_disponivel;

    public Produto() {
    }

    public Produto(String produtos, String medida) {
        this.produtos = produtos;
        this.medida = medida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getQtde() {
        return qtde_disponivel;
    }

    public void setQtde(int qtde_disponivel) {
        this.qtde_disponivel = qtde_disponivel;
    }

	@Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", produtos='" + produtos + '\'' +
                ", medida='" + medida + '\'' +
                ", preco=" + preco +
                ", qtde_disponivel='" + qtde_disponivel + '\'' +
                '}';
    }
}
