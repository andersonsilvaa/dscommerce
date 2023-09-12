package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProdutoDto;
import com.devsuperior.dscommerce.entities.Produto;
import com.devsuperior.dscommerce.repositories.ProdutoRepository;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDto consultarPorId(Long id) {

        Produto produto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ModelMapper().map(produto, ProdutoDto.class);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDto> consultarTodos(Pageable pagina) {

        Page<Produto> produtos = repository.findAll(pagina);
        return produtos.map(produto -> new ProdutoDto(produto));
    }

    @Transactional
    public ProdutoDto salvar(ProdutoDto dto) {

        Produto produto = new Produto(dto);
        produto = repository.save(produto);
        return new ProdutoDto(produto);
    }

    @Transactional
    public ProdutoDto atualizar(Long id, ProdutoDto dto) {

        try {
            Produto produto = repository.getReferenceById(id);
            produto.dtoToEntity(dto);
            produto = repository.save(produto);
            return new ProdutoDto(produto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}

