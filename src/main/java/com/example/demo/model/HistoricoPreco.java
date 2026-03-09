package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class HistoricoPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;
    private LocalDateTime dataVerificacao;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto; // Liga o preço ao produto específico
}