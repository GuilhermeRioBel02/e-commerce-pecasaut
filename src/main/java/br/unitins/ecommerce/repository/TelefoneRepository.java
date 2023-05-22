package br.unitins.ecommerce.repository;

import java.util.List;

import br.unitins.ecommerce.model.Telefone;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

        public List<Telefone> findByNumero(String numero) {
            if (numero == null)
                return null;
            return find("UPPER(numero) LIKE ?1 ", "%" + numero.toUpperCase() + "%").list();
        }

}
