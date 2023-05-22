package br.unitins.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoriaVeiculo {
    PASSEIO(1, "Passeio"),
    UTILITARIO(2, "Utilitário"),
    MOTO(3, "Moto"),
    VAN(4, "Van");

    private int id;
    private String label;

    CategoriaVeiculo(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {

        return label;

    }

    public static CategoriaVeiculo valueOf(Integer id) throws IllegalArgumentException {

        if (id == null) {
            return null;

        }

        for (CategoriaVeiculo categoriaVeiculo : CategoriaVeiculo.values()) {

            if (id.equals(categoriaVeiculo.getId())) {
                return categoriaVeiculo;

            }
        }

        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
