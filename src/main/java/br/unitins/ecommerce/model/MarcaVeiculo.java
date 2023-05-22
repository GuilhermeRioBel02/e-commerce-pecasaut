package br.unitins.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MarcaVeiculo {
    FIAT(1, "Fiat"),
    VOLKSWAGEN(2, "Volkswagen"),
    CHEVROLET(3, "Chevrolet"),
    FORD(4, "Ford"),
    TOYOTA(5, "Toyota"),
    RENAULT(6, "Renault"),
    HONDA(7, "Honda"),
    SUZUKI(8, "Suzuki");

    private int id;
    private String label;

    MarcaVeiculo(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {

        return label;

    }

    public static MarcaVeiculo valueOf(Integer id) throws IllegalArgumentException {

        if (id == null) {
            return null;

        }

        for (MarcaVeiculo marcaVeiculo : MarcaVeiculo.values()) {

            if (id.equals(marcaVeiculo.getId())) {
                return marcaVeiculo;

            }
        }

        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
