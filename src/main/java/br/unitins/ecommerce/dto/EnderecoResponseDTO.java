package br.unitins.ecommerce.dto;

import br.unitins.ecommerce.model.Endereco;
import br.unitins.ecommerce.model.Estado;
import br.unitins.ecommerce.model.Municipio;


public record EnderecoResponseDTO(
        Long id,
        boolean principal,
        String logradouro,
        String bairro,
        String numero,
        String complemento,
        String cep,
        Municipio municipio,
        Estado estado
) {
    public EnderecoResponseDTO(Endereco endereco) {
        this(endereco.getId(), endereco.isPrincipal(), endereco.getLogradouro(), endereco.getNumero(),
                endereco.getComplemento(), endereco.getBairro(), endereco.getCep(),
                endereco.getMunicipio(), endereco.getEstado());
    }
}
