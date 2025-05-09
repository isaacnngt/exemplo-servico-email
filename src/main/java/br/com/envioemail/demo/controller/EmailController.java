package br.com.envioemail.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.envioemail.demo.dto.EmailRequestDTO;
import br.com.envioemail.demo.service.EmailService;
import jakarta.validation.Valid;

/**
 * Controlador REST para operações de envio de e-mail.
 * Expõe endpoints HTTP para interagir com o serviço de e-mail.
 */
@RestController
@RequestMapping("/api/email")
public class EmailController {

    /**
     * Serviço responsável pela lógica de envio de e-mail.
     */
    @Autowired
    private EmailService emailService;

    /**
     * Endpoint para envio de e-mail.
     *
     * @param emailRequest Dados do e-mail a ser enviado (validados através da anotação @Valid)
     * @return Resposta HTTP com mensagem de sucesso ou erro
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailRequestDTO emailRequest) {
        try {
            // Delega a operação para o serviço
            emailService.sendEmail(emailRequest);
            return new ResponseEntity<>("E-mail enviado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            // Em caso de erro, retorna 500 com a mensagem
            return new ResponseEntity<>("Erro ao enviar e-mail: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}