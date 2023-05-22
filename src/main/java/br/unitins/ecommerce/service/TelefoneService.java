package br.unitins.ecommerce.service;


import java.util.List;

import br.unitins.ecommerce.dto.TelefoneDTO;
import br.unitins.ecommerce.dto.TelefoneResponseDTO;

public interface TelefoneService {

    List<TelefoneResponseDTO> getAll();

    TelefoneResponseDTO findById(Long id);

    TelefoneResponseDTO create(TelefoneDTO telefoneDTO);

    TelefoneResponseDTO update(Long id, TelefoneDTO telefoneDTO);

    void delete(Long id);

    List<TelefoneResponseDTO> findByNumero(String numero);

    Long count();

}
