package br.unitins.ecommerce.service;

import java.util.List;

import br.unitins.ecommerce.dto.UsuarioDTO;
import br.unitins.ecommerce.dto.UsuarioResponseDTO;

public interface UsuarioService {

    List<UsuarioResponseDTO> getAll();

    UsuarioResponseDTO findById(Long id);

    UsuarioResponseDTO create(UsuarioDTO usuarioDTO);

    UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO);

    void delete(Long id);

    List<UsuarioResponseDTO> findByCpf(String cpf);

    Long count();
}