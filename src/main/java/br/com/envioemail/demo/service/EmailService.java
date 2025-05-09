package br.com.envioemail.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import br.com.envioemail.demo.dto.EmailRequestDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Serviço responsável pelo envio de e-mails.
 * Simplificado para garantir funcionamento sem depender de variáveis de ambiente.
 */
@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Envia um e-mail com base nos dados fornecidos na requisição.
     *
     * @param emailRequest Objeto contendo as informações do e-mail a ser enviado
     * @throws RuntimeException se ocorrer algum erro durante o envio
     */
    public void sendEmail(EmailRequestDTO emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            // Obter configurações diretamente do JavaMailSender (abordagem mais confiável)
            String sender = obterEmailRemetente();
            logger.debug("Usando remetente: {}", sender);

            // Configurar remetente
            message.setFrom(sender);

            // Configurar destinatário - usar o fornecido ou uma alternativa padrão
            String recipient = emailRequest.getRecipient();
            if (recipient == null || recipient.isEmpty()) {
                recipient = "seu-email@gmail.com"; // destinatário padrão fixo para garantir funcionamento
                logger.debug("Usando destinatário padrão: {}", recipient);
            }
            message.setTo(recipient);

            // Configurar assunto - usar o fornecido ou um padrão
            String subject = emailRequest.getSubject();
            if (subject == null || subject.isEmpty()) {
                subject = "Notificação do Sistema";
                logger.debug("Usando assunto padrão: {}", subject);
            }
            message.setSubject(subject);

            // Configurar corpo do e-mail
            message.setText(emailRequest.getDescription());

            // Envia e-mail
            logger.info("Enviando e-mail para: {}", recipient);
            mailSender.send(message);
            logger.info("E-mail enviado com sucesso");

        } catch (Exception e) {
            logger.error("Erro ao enviar e-mail: {}", e.getMessage(), e);
            throw new RuntimeException("Falha ao enviar e-mail: " + e.getMessage(), e);
        }
    }

    /**
     * Obtém o endereço de e-mail do remetente diretamente da configuração do JavaMailSender.
     * Garante que sempre haverá um remetente válido.
     *
     * @return Um endereço de e-mail válido para o remetente
     */
    private String obterEmailRemetente() {
        // Verificar se podemos obter username diretamente do JavaMailSender
        if (mailSender instanceof JavaMailSenderImpl) {
            JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) mailSender;
            String username = mailSenderImpl.getUsername();

            // Se temos um username configurado
            if (username != null && !username.isEmpty()) {
                // Verificar se já é um e-mail completo
                if (username.contains("@")) {
                    return username;
                }

                // Caso contrário, completar com domínio baseado no host
                String host = mailSenderImpl.getHost();
                if (host.contains("gmail")) {
                    return username + "@gmail.com";
                } else if (host.contains("outlook") || host.contains("hotmail")) {
                    return username + "@outlook.com";
                } else if (host.contains("yahoo")) {
                    return username + "@yahoo.com";
                } else {
                    // Para outros servidores, usar domínio baseado no host
                    String domain = host.replace("smtp.", "");
                    return username + "@" + domain;
                }
            }
        }

        // Se não conseguirmos obter o remetente da configuração, usar um valor padrão
        // que sabemos que funciona para este projeto específico
        return "gguruagile@gmail.com";
    }
}