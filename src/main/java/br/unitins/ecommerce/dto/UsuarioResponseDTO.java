package br.unitins.ecommerce.dto;

import java.util.List;

import br.unitins.ecommerce.model.Usuario;
import br.unitins.ecommerce.model.Endereco;
import br.unitins.ecommerce.model.Produto;
import br.unitins.ecommerce.model.Telefone;


public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        List<Endereco> enderecos,
        List<Telefone> telefones,
        List<Produto> listaDesejo
        String nomeImagem;
) {
    public UsuarioResponseDTO(Usuario usuario) {

        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf(), usuario.getEnderecos(),
                usuario.getTelefones(), usuario.getListaDesejo(), usuaeio.getNomeImagem);

    }
}
