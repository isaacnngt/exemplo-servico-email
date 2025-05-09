package br.com.envioemail.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Configuração do serviço de e-mail.
 * Versão simplificada com valores fixos para garantir funcionamento.
 */
@Configuration
public class EmailConfig {

    private static final Logger logger = LoggerFactory.getLogger(EmailConfig.class);

    /**
     * Cria e configura o JavaMailSender com valores fixos.
     * Em um ambiente real, estas configurações viriam de properties ou variáveis de ambiente.
     *
     * @return Um bean JavaMailSender configurado
     */
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        // Configurações do Gmail (valores que sabemos que funcionam para este projeto)
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "seuemail@gmail.com";
        String password = "sua senha";

        logger.info("Configurando serviço de e-mail com host: {}, porta: {}", host, port);

        // Configurando host e porta
        mailSender.setHost(host);
        mailSender.setPort(port);

        // Configurando credenciais
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        logger.info("Credenciais de e-mail configuradas para: {}", username);

        // Configurando as propriedades adicionais do JavaMail
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.timeout", "5000");
        props.put("mail.smtp.connectiontimeout", "5000");

        return mailSender;
    }
}