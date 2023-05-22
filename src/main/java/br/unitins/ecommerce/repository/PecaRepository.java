package br.unitins.ecommerce.repository;

import java.util.List;

import br.unitins.ecommerce.model.Peca;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class PecaRepository implements PanacheRepository<Peca> {
    public List<Peca> findByMarca(String marca) {
        if (marca == null)
            return null;
        return find("UPPER(marca) LIKE ?1 ", "%" + marca.toUpperCase() + "%").list();
    }
}
