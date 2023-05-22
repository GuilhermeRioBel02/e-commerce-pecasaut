package br.unitins.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


import br.unitins.ecommerce.model.Peca;
import br.unitins.ecommerce.model.CategoriaPeca;
import br.unitins.ecommerce.model.CategoriaVeiculo;
import br.unitins.ecommerce.model.MarcaVeiculo;


public record PecaResponseDTO(

        String marca,
        String modelo,
        @JsonInclude(JsonInclude.Include.NON_NULL) CategoriaPeca categoriaPeca,
        CategoriaVeiculo categoriaVeiculo,
        MarcaVeiculo marcaVeiculo
) {
    public PecaResponseDTO(Peca peca) {
        this(peca.getMarca(), peca.getModelo(), peca.getCategoriaPeca(),
                peca.getCategoriaVeiculo(), peca.getMarcaVeiculo());
    }

}
