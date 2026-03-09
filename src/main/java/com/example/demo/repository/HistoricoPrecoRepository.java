package com.example.demo.repository;

import com.example.demo.model.HistoricoPreco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoricoPrecoRepository extends JpaRepository<HistoricoPreco, Long> {
    List<HistoricoPreco> findByProdutoIdOrderByDataVerificacaoAsc(Long produtoId);
}