package com.devsuperior.dscommerce.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidacaoErro extends ErroCustomizado {

    private List<Mensagem> errors = new ArrayList<>();

    public ValidacaoErro(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void adicionarErro(String campo, String mensagem){
        this.errors.add(new Mensagem(campo, mensagem));
    }
}
