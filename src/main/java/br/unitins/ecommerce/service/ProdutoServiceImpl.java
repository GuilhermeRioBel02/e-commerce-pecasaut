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
import br.unitins.ecommerce.dto.ProdutoDTO;
import br.unitins.ecommerce.dto.ProdutoResponseDTO;
import br.unitins.ecommerce.model.Produto;
import br.unitins.ecommerce.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    Validator validator;

    @Override
    public List<ProdutoResponseDTO> getAll() {
        List<Produto> list = produtoRepository.listAll();
        return list.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id);
        if (produto == null)
            throw new NotFoundException("Peca não localizado.");
        return new ProdutoResponseDTO(produto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO create(ProdutoDTO produtoDTO) throws ConstraintViolationException {
        read(produtoDTO);

        Produto entity = new Produto();
        entity.setNome(produtoDTO.nome());
        entity.setDescricao(produtoDTO.descricao());
        entity.setPreco(produtoDTO.preco());
        entity.setEstoque(produtoDTO.estoque());

        produtoRepository.persist(entity);

        return new ProdutoResponseDTO(entity);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(Long id, ProdutoDTO produtoDTO) throws ConstraintViolationException {
        read(produtoDTO);

        Produto produtoUpdate = produtoRepository.findById(id);
        if (produtoUpdate == null)
            throw new NotFoundException("Produto não localizado.");
        read(produtoDTO);
        produtoUpdate.setNome(produtoDTO.nome());
        produtoUpdate.setDescricao(produtoDTO.descricao());
        produtoUpdate.setPreco(produtoDTO.preco());
        produtoUpdate.setEstoque(produtoDTO.estoque());
        produtoRepository.persist(produtoUpdate);

        return new ProdutoResponseDTO(produtoUpdate);
    }

    private void read(ProdutoDTO produtoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ProdutoDTO>> violations = validator.validate(produtoDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        produtoRepository.deleteById(id);

    }

    @Override
    public List<ProdutoResponseDTO> findByNome(String nome) {

        List<Produto> list = produtoRepository.findByNome(nome);
        return list.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());

    }

    @Override
    public Long count() {

        return produtoRepository.count();

    }

}
