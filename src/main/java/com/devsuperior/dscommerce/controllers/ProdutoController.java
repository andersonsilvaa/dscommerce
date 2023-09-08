package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProdutoDto;
import com.devsuperior.dscommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "{id}")
    public ProdutoDto consultarPorId(@PathVariable Long id) {
        return service.consultarPorId(id);
    }

    @GetMapping
    public Page<ProdutoDto> consultarTodos(Pageable pagina) {
        return service.consultarTodos(pagina);
    }
}
