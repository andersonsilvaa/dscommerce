package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Produto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@Getter
@Setter
public class ProdutoDto {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String nome;

    @Size(min = 10, message = "Nome precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String descricao;

    @Positive(message = "O preço deve ser positivo")
    private Double preco;

    private String urlImagem;

    public ProdutoDto(Produto produto) {
        new ModelMapper().map(produto, this);
    }
}
