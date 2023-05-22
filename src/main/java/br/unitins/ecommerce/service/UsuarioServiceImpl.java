package br.unitins.ecommerce.service;

import java.util.ArrayList;
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
import br.unitins.ecommerce.dto.UsuarioDTO;
import br.unitins.ecommerce.dto.UsuarioResponseDTO;
import br.unitins.ecommerce.model.Usuario;
import br.unitins.ecommerce.model.Endereco;
import br.unitins.ecommerce.model.Produto;
import br.unitins.ecommerce.model.Telefone;
import br.unitins.ecommerce.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {


    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponseDTO> getAll() {
        List<Usuario> list = usuarioRepository.listAll();
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null)
            throw new NotFoundException("Usuario não encontrado.");
        return new UsuarioResponseDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.nome());
        entity.setEmail(usuarioDTO.email());
        entity.setCpf(usuarioDTO.cpf());

        entity.setEnderecos(new ArrayList<Endereco>());
        for (Long idEndereco : usuarioDTO.idEnderecos()) {
            Endereco endereco = new Endereco();
            endereco.setId(idEndereco);
            entity.getEnderecos().add(endereco);
        }

        entity.setTelefones(new ArrayList<Telefone>());
        for (Long idTelefones : usuarioDTO.idTelefones()) {
            Telefone telefone = new Telefone();
            telefone.setId(idTelefones);
            entity.getTelefones().add(telefone);
        }

        entity.setListaDesejo(new ArrayList<Produto>());
        for (Long idListaDesejo : usuarioDTO.idListaDesejo()) {
            Produto produto = new Produto();
            produto.setId(idListaDesejo);
            entity.getListaDesejo().add(produto);
        }

        usuarioRepository.persist(entity);

        return new UsuarioResponseDTO(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Usuario usuarioUpdate = usuarioRepository.findById(id);
        if (usuarioUpdate == null)
            throw new NotFoundException("Usuário não encontrado.");
        validar(usuarioDTO);
        usuarioUpdate.setNome(usuarioDTO.nome());
        usuarioUpdate.setEmail(usuarioDTO.email());
        usuarioUpdate.setCpf(usuarioDTO.cpf());

        usuarioUpdate.setEnderecos(new ArrayList<Endereco>());
        for (Long idEndereco : usuarioDTO.idEnderecos()) {
            Endereco endereco = new Endereco();
            endereco.setId(idEndereco);
            usuarioUpdate.getEnderecos().add(endereco);
        }

        usuarioUpdate.setTelefones(new ArrayList<Telefone>());
        for (Long idTelefones : usuarioDTO.idTelefones()) {
            Telefone telefone = new Telefone();
            telefone.setId(idTelefones);
            usuarioUpdate.getTelefones().add(telefone);
        }

        usuarioUpdate.setListaDesejo(new ArrayList<Produto>());
        for (Long idListaDesejo : usuarioDTO.idListaDesejo()) {
            Produto produto = new Produto();
            produto.setId(idListaDesejo);
            usuarioUpdate.getListaDesejo().add(produto);
        }

        usuarioRepository.persist(usuarioUpdate);

        return new UsuarioResponseDTO(usuarioUpdate);
    }

    private void validar(UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(usuarioDTO);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        List<Usuario> list = usuarioRepository.findByCpf(cpf);
        return list.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return usuarioRepository.count();
    }
}