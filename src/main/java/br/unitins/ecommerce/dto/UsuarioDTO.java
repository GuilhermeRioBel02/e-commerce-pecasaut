package br.unitins.ecommerce.dto;

import java.util.List;


public record UsuarioDTO(
        String nome,
        String email,
        String cpf,
        List<Long> idEnderecos,
        List<Long> idTelefones,
        List<Long> idListaDesejo
) {
}
