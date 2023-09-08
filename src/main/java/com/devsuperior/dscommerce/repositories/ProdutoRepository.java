package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
