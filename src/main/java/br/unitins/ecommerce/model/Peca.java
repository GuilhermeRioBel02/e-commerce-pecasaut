package br.unitins.ecommerce.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Peca extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String marca;
    private String modelo;
    private CategoriaPeca categoriaPeca;
    private CategoriaVeiculo categoriaVeiculo;
    private MarcaVeiculo marcaVeiculo;

    @ManyToOne
    public String getMarca() {

        return marca;

    }

    public void setMarca(String marca) {

        this.marca = marca;

    }

    public String getModelo() {

        return modelo;

    }

    public void setModelo(String modelo) {

        this.modelo = modelo;

    }

    public CategoriaPeca getCategoriaPeca() {

        return categoriaPeca;

    }

    public void setCategoriaPeca(CategoriaPeca categoriaPeca) {

        this.categoriaPeca = categoriaPeca;

    }

    public CategoriaVeiculo getCategoriaVeiculo() {

        return categoriaVeiculo;

    }

    public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {

        this.categoriaVeiculo = categoriaVeiculo;

    }

    public MarcaVeiculo getMarcaVeiculo() {

        return marcaVeiculo;

    }

    public void setMarcaVeiculo(MarcaVeiculo marcaVeiculo) {

        this.marcaVeiculo = marcaVeiculo;

    }

}
