package br.unitins.ecommerce.converterjpa;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.ecommerce.model.MarcaVeiculo;

@Converter(autoApply = true)
public class MarcaVeiculoConverter implements AttributeConverter<MarcaVeiculo, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MarcaVeiculo marcaVeiculo) {

        return marcaVeiculo == null ? null : marcaVeiculo.getId();
    }

    @Override
    public MarcaVeiculo convertToEntityAttribute(Integer id) {

        return MarcaVeiculo.valueOf(id);

    }

}