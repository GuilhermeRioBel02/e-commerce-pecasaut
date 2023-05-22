package br.unitins.ecommerce.dto;


import br.unitins.ecommerce.model.Produto;


public record ProdutoResponseDTO(

        Long id,
        String nome,
        String descricao,
        Float preco,
        Integer estoque

) {
    public ProdutoResponseDTO(Produto produto) {

        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getEstoque());

    }
}
