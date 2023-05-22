package br.unitins.ecommerce.dto;

public record ProdutoDTO(

        Long id,
        String nome,
        String descricao,
        Float preco,
        Integer estoque

) {
}
