package br.unitins.ecommerce.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.ecommerce.model.CategoriaVeiculo;

@Converter(autoApply = true)
public class CategoriaVeiculoConverter implements AttributeConverter<CategoriaVeiculo, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoriaVeiculo categoriaVeiculo) {
        return categoriaVeiculo == null ? null : categoriaVeiculo.getId();
    }

    @Override
    public CategoriaVeiculo convertToEntityAttribute(Integer id) {

        return CategoriaVeiculo.valueOf(id);
    }

}