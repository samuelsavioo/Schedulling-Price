package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.chat.id}")
    private String chatId;

    private final RestTemplate restTemplate = new RestTemplate();
    public void enviarAlerta(String mensagem) {
        String url = "https://api.telegram.org/bot" + token + "/sendMessage?chat_id=" + chatId + "&text=" + mensagem;
        try {
            restTemplate.getForObject(url, String.class);
            System.out.println(">>> Notificação enviada para o Telegram");
        } catch (Exception e) {
            System.out.println(">>> Erro ao enviar o Telegram" + e.getMessage());
        }
    }
}
