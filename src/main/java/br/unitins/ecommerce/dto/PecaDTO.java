package br.unitins.ecommerce.dto;


public record PecaDTO(
        String marca,
        String modelo,
        Integer categoriaPeca,
        Integer categoriaVeiculo,
        Integer marvaVeiculo
) {
}
