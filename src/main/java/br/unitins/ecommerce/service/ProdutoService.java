package br.unitins.ecommerce.service;

import java.util.List;

import br.unitins.ecommerce.dto.ProdutoDTO;
import br.unitins.ecommerce.dto.ProdutoResponseDTO;

public interface ProdutoService {

    List<ProdutoResponseDTO> getAll();

    ProdutoResponseDTO findById(Long id);

    ProdutoResponseDTO create(ProdutoDTO produtoDTO);

    ProdutoResponseDTO update(Long id, ProdutoDTO produtoDTO);

    void delete(Long id);

    List<ProdutoResponseDTO> findByNome(String nome);

    Long count();

}
