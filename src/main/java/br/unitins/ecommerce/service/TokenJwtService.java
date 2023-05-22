package br.unitins.ecommerce.service;

import br.unitins.ecommerce.model.Usuario;


public interface TokenJwtService {
    public String generateJwt(Usuario usuario);
}
