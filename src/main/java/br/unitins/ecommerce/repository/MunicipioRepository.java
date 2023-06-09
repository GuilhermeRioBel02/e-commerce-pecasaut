package br.unitins.ecommerce.repository;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import br.unitins.ecommerce.model.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MunicipioRepository implements PanacheRepository<Municipio> {

    public List<Municipio> findByNome(String nome){

        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();

    }

}
