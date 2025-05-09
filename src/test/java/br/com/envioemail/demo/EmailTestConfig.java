package br.com.envioemail.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Classe de teste para verificar a configuração do e-mail durante a inicialização
 * Ativa apenas com o perfil "test-mail"
 */
@Configuration
@Profile("test-mail")
public class EmailTestConfig {

    private static final Logger logger = LoggerFactory.getLogger(EmailTestConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public CommandLineRunner testEmailConfig(JavaMailSender mailSender) {
        return args -> {
            logger.info("Testando configuração de e-mail:");

            // Verifica se mailSender é uma instância de JavaMailSenderImpl
            if (mailSender instanceof JavaMailSenderImpl) {
                JavaMailSenderImpl sender = (JavaMailSenderImpl) mailSender;

                logger.info("Host: {}", sender.getHost());
                logger.info("Porto: {}", sender.getPort());
                logger.info("Protocolo: {}", sender.getJavaMailProperties().getProperty("mail.transport.protocol"));
                logger.info("Autenticação SMTP: {}", sender.getJavaMailProperties().getProperty("mail.smtp.auth"));
                logger.info("Remetente: {}", sender.getUsername());

                // Verificações críticas
                if (sender.getUsername() == null || sender.getUsername().isEmpty()) {
                    logger.error("ATENÇÃO: Remetente não configurado. Isso causará MailParseException.");
                } else if (!sender.getUsername().contains("@")) {
                    logger.warn("ATENÇÃO: Remetente '{}' não parece ser um endereço de e-mail válido",
                            sender.getUsername());
                }

                logger.info("Valores do environment:");
                logger.info("spring.mail.host = {}", env.getProperty("spring.mail.host"));
                logger.info("spring.mail.username = {}", env.getProperty("spring.mail.username"));
                logger.info("email.default-recipient = {}", env.getProperty("email.default-recipient"));
            }
        };
    }
}