package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoDto {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private String urlImagem;

    public ProdutoDto(Produto produto) {
        new ModelMapper().map(produto, this);
    }
}
