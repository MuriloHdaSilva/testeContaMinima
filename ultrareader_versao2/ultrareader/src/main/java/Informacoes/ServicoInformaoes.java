package Informacoes;

import br.com.contaminima.ultrareader.RegistroServico;

public class ServicoInformaoes implements RegistroServico {
    private String Data;
    private String Origem;
    private String Descricao;
    private Double Valor;

    @Override
    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    @Override
    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }

    @Override
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    @Override
    public Double getValor() {
        return Valor;
    }

    public void setValor(Double valor) {
        Valor = valor;
    }
}
