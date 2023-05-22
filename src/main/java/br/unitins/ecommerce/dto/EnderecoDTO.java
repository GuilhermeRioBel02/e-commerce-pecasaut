package br.unitins.ecommerce.dto;


public record EnderecoDTO(
        Boolean principal,
        String logradouro,
        String bairro,
        String numero,
        String complemento,
        String cep,
        Long idEstado,
        Long idMunicipio
) {
}
