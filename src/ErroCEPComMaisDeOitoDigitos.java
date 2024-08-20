package br.com.buscaCEP.excecoes;

public class ErroCEPComMaisDeOitoDigitos extends RuntimeException {
    private String mensagem;

    public ErroCEPComMaisDeOitoDigitos(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
