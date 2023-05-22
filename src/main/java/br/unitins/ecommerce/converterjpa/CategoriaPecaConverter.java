package br.unitins.ecommerce.converterjpa;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.ecommerce.model.CategoriaPeca;

@Converter(autoApply = true)
public class CategoriaPecaConverter implements AttributeConverter<CategoriaPeca, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoriaPeca categoriaPeca) {
        return categoriaPeca == null ? null : categoriaPeca.getId();
    }

    @Override
    public CategoriaPeca convertToEntityAttribute(Integer id) {
        return CategoriaPeca.valueOf(id);
    }
}

