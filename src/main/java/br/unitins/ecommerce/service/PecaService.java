package br.unitins.ecommerce.service;


import java.util.List;

import br.unitins.ecommerce.dto.PecaDTO;
import br.unitins.ecommerce.dto.PecaResponseDTO;

public interface PecaService {

    List<PecaResponseDTO> getAll();

    PecaResponseDTO findById(Long id);

    PecaResponseDTO create(PecaDTO pecaDTO);

    PecaResponseDTO update(Long id, PecaDTO pecaDTO);

    void delete(Long id);

    List<PecaResponseDTO> findByMarca(String marca);

    Long count();

}
