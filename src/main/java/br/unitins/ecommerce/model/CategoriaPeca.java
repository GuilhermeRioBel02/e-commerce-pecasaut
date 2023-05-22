package br.unitins.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoriaPeca {

    ELETRICA(1, "Eletrica"),
    SUSPENSAO(2, "Suspensao"),
    MOTOR(3, "Motor"),
    FREIO(4, "Freio"),
    TRANSMISSAO(5, "Transmissao"),
    PNEU(6, "Pneu");

    private int id;
    private String label;

    CategoriaPeca(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {

        return label;

    }

    public static CategoriaPeca valueOf(Integer id) throws IllegalArgumentException {

        if (id == null) {
            return null;

        }

        for (CategoriaPeca categoriaPeca : CategoriaPeca.values()) {

            if (id.equals(categoriaPeca.getId())) {
                return categoriaPeca;

            }
        }

        throw new IllegalArgumentException("Id inválido:" + id);
    }

}
