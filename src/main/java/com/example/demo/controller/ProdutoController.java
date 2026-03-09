package com.example.demo.controller;
import com.example.demo.model.Produto;
import com.example.demo.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ScraperService scraperService;
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        produto.setPrecoAtual(scraperService.obterPreco(produto.getUrl()));
        produto.setUltimaVerificacao(LocalDateTime.now());
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return repository.findAll();
    }

    @GetMapping("/testar")
    public String testarScraper(@RequestParam String url) {
        BigDecimal preco = scraperService.obterPreco(url);
        return (preco != null)
                ? "O preço encontrado foi: R$ " + preco
                : "Não foi possível encontrar o preço neste link. Verifique o seletor";
    }
}