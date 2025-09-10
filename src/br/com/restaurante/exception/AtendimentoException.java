package br.com.restaurante.exception;

public class AtendimentoException extends Exception {

    public AtendimentoException(String mensagem) {
        super(mensagem);
    }

    public AtendimentoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}