package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "url_imagem")
    private String urlImagem;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.produto")
    private Set<PedidoItem> itens;

    public List<Pedido> getPedidos() {
        return itens.stream().map(item -> item.getPedido()).toList();
    }
}
