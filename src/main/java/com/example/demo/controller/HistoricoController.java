package com.example.demo.controller;

import com.example.demo.model.HistoricoPreco;
import com.example.demo.repository.HistoricoPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping

public class HistoricoController {
    @Autowired
    private HistoricoPrecoRepository repository;

    @GetMapping("/{produtoId")
    public List<HistoricoPreco> Lister(@PathVariable Long PodutoId) {
        return repository.findByProdutoIdOrderByDataVerificacaoAsc(PodutoId);
    }
}
