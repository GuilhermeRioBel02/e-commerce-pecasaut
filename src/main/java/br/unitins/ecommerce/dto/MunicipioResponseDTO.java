package br.unitins.ecommerce.dto;


import br.unitins.ecommerce.model.Estado;
import br.unitins.ecommerce.model.Municipio;
public record MunicipioResponseDTO(
        Long id,
        String nome,
        Estado estado
) {
    public MunicipioResponseDTO(Municipio municipio) {

        this(municipio.getId(), municipio.getNome(), municipio.getEstado());

    }

}
