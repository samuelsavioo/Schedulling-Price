package com.example.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class ScraperService {

    public BigDecimal obterPreco(String url) {
        try {
            // Conecta à URL e baixa o HTML do site
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0") // Simula um navegador para evitar bloqueios
                    .get();


            Element elementoPreco = doc.selectFirst(".a-price-whole");

            if (elementoPreco != null) {
                // Limpa o texto (remove R$, espaços) e converte para número
                String precoTexto = elementoPreco.text().replaceAll("[^0-9,]", "").replace(",", ".");
                return new BigDecimal(precoTexto);
            }
        } catch (IOException e) {
            System.err.println("Erro ao acessar o site: " + e.getMessage());
        }
        return null; // Retorna null se não conseguir encontrar o preço
    }
}