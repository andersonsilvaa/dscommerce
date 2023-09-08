package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProdutoDto;
import com.devsuperior.dscommerce.entities.Produto;
import com.devsuperior.dscommerce.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDto consultarPorId(Long id) {

        Produto produto = repository.findById(id).get();
        return new ModelMapper().map(produto, ProdutoDto.class);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDto> consultarTodos(Pageable pagina) {

        Page<Produto> produtos = repository.findAll(pagina);
        return produtos.map(produto -> new ProdutoDto(produto));
    }
}
