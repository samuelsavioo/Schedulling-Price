package com.example.demo.service;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.example.demo.model.HistoricoPreco;
import com.example.demo.repository.HistoricoPrecoRepository;


@Service
public class AgendadorService {



    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ScraperService scraperService;

    @Autowired
    private HistoricoPrecoRepository historicoRepository;

    @Scheduled(fixedRate = 10000)
    public void verificarPreco() {
        List<Produto> produtos = repository.findAll();

        for (Produto produto : produtos) {
            BigDecimal novoPreco = scraperService.obterPreco(produto.getUrl());

            if (novoPreco != null) {
                System.out.println("Verificando " + produto.getNome() + ": R$" + novoPreco);


                if (novoPreco.compareTo(produto.getPrecoAlvo()) <= 0) {
                    String mensagemTelegram = "Alerta de preço: O " + produto.getNome() +
                            " baixou para R$ " + novoPreco +
                            "! Link: " + produto.getUrl();

                    notificationService.enviarAlerta(mensagemTelegram);
                    System.out.println("Alerta enviado para o Telegram");
                }

                produto.setPrecoAtual(novoPreco);
                produto.setUltimaVerificacao(LocalDateTime.now());
                repository.save(produto);
                HistoricoPreco historico = new HistoricoPreco();
                historico.setPreco(novoPreco);
                historico.setDataVerificacao(LocalDateTime.now());
                historico.setProduto(produto);
                historicoRepository.save(historico);
            }
        }
    }
}
