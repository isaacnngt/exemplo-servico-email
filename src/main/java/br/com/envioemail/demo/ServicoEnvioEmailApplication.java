package br.com.envioemail.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot para o serviço de envio de e-mails.
 * Inicializa o contexto da aplicação Spring.
 */
@SpringBootApplication
public class ServicoEnvioEmailApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     * 
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(ServicoEnvioEmailApplication.class, args);
    }
}