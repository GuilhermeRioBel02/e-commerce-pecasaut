package br.unitins.ecommerce.service;

import java.util.List;
import br.unitins.ecommerce.dto.MunicipioDTO;
import br.unitins.ecommerce.dto.MunicipioResponseDTO;

public interface MunicipioService {

    // recursos basicos
    List<MunicipioResponseDTO> getAll();

    MunicipioResponseDTO findById(Long id);

    MunicipioResponseDTO create(MunicipioDTO productDTO);

    MunicipioResponseDTO update(Long id, MunicipioDTO productDTO);

    void delete(Long id);

    // recursos extras

    List<MunicipioResponseDTO> findByNome(String nome);

    long count();

}
