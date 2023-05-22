package br.unitins.ecommerce.dto;


import br.unitins.ecommerce.model.Estado;


public record EstadoResponseDTO(
        Long id,
        String nome,
        String sigla
) {
    public EstadoResponseDTO(Estado estado) {

        this(estado.getId(), estado.getSigla(), estado.getNome());

    }
}
