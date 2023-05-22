package br.unitins.ecommerce.service;


import java.util.List;
import java.util.Set;

import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;
import br.unitins.ecommerce.dto.PecaDTO;
import br.unitins.ecommerce.dto.PecaResponseDTO;
import br.unitins.ecommerce.model.Peca;
import br.unitins.ecommerce.model.CategoriaPeca;
import br.unitins.ecommerce.model.CategoriaVeiculo;
import br.unitins.ecommerce.model.MarcaVeiculo;
import br.unitins.ecommerce.repository.PecaRepository;

@ApplicationScoped
public class PecaServiceImpl implements PecaService {

    @Inject
    PecaRepository pecaRepository;

    @Inject
    Validator validator;

    @Override
    public List<PecaResponseDTO> getAll() {
        List<Peca> list = pecaRepository.listAll();
        return list.stream().map(PecaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public PecaResponseDTO findById(Long id) {
        Peca peca = pecaRepository.findById(id);
        if (peca == null)
            throw new NotFoundException("Peca não localizada.");
        return new PecaResponseDTO(peca);
    }

    @Override
    @Transactional
    public PecaResponseDTO create(PecaDTO pecaDTO) throws ConstraintViolationException {
        read(pecaDTO);

        Peca entity = new Peca();
        entity.setMarca(pecaDTO.marca());
        entity.setModelo(pecaDTO.modelo());
        entity.setCategoriaPeca(CategoriaPeca.valueOf(pecaDTO.categoriaPeca()));
        entity.setCategoriaVeiculo(CategoriaVeiculo.valueOf(pecaDTO.categoriaVeiculo()));
        entity.setMarcaVeiculo(MarcaVeiculo.valueOf(pecaDTO.marvaVeiculo()));

        pecaRepository.persist(entity);

        return new PecaResponseDTO(entity);
    }

    @Override
    @Transactional
    public PecaResponseDTO update(Long id, PecaDTO pecaDTO) throws ConstraintViolationException {
        Peca pecaUpdate = pecaRepository.findById(id);
        if (pecaUpdate == null)
            throw new NotFoundException("Peca não localizada.");
        read(pecaDTO);
        pecaUpdate.setMarca(pecaDTO.marca());
        pecaUpdate.setModelo(pecaDTO.modelo());
        pecaUpdate.setCategoriaPeca(CategoriaPeca.valueOf(pecaDTO.categoriaPeca()));
        pecaUpdate.setCategoriaVeiculo(CategoriaVeiculo.valueOf(pecaDTO.categoriaVeiculo()));
        pecaUpdate.setMarcaVeiculo(MarcaVeiculo.valueOf(pecaDTO.marvaVeiculo()));

        pecaRepository.persist(pecaUpdate);

        return new PecaResponseDTO(pecaUpdate);
    }

    private void read(PecaDTO pecaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PecaDTO>> violations = validator.validate(pecaDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        pecaRepository.deleteById(id);

    }

    @Override
    public List<PecaResponseDTO> findByMarca(String marca) {
        List<Peca> list = pecaRepository.findByMarca(marca);
        return list.stream().map(PecaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count() {

        return pecaRepository.count();

    }
}
