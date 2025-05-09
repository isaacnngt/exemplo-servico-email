package br.com.envioemail.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para transportar os dados da requisição de envio de e-mail.
 * Contém validações para garantir que os dados estejam no formato correto.
 */
public class EmailRequestDTO {

    /**
     * Conteúdo do e-mail. Não pode estar em branco e tem limite de tamanho.
     */
    @NotBlank(message = "A descrição não pode estar vazia")
    @Size(min = 1, max = 10000, message = "A descrição deve ter entre 1 e 10000 caracteres")
    private String description;

    /**
     * E-mail do destinatário. Deve ser um e-mail válido mas pode ser nulo.
     * Se for nulo, o sistema usará um destinatário padrão.
     */
    @Email(message = "Formato de e-mail inválido")
    private String recipient;

    /**
     * Assunto do e-mail. Tem tamanho máximo definido.
     * Se não for informado, será usado um valor padrão.
     */
    @Size(max = 255, message = "O assunto não pode ter mais de 255 caracteres")
    private String subject;

    /**
     * Construtor padrão.
     */
    public EmailRequestDTO() {
    }

    /**
     * Construtor que permite definir todos os campos.
     *
     * @param description Conteúdo do e-mail
     * @param recipient E-mail do destinatário
     * @param subject Assunto do e-mail
     */
    public EmailRequestDTO(String description, String recipient, String subject) {
        this.description = description;
        this.recipient = recipient;
        this.subject = subject;
    }

    /**
     * @return O conteúdo do e-mail
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Define o conteúdo do e-mail
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return O e-mail do destinatário
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * @param recipient Define o e-mail do destinatário
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return O assunto do e-mail
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject Define o assunto do e-mail
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}