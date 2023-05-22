package br.unitins.ecommerce.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import br.unitins.ecommerce.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> findByCep(String cep) {

        if (cep == null)
            return null;
        return find("UPPER(cep) LIKE ?1 ", "%" + cep.toUpperCase() + "%").list();

    }

}
