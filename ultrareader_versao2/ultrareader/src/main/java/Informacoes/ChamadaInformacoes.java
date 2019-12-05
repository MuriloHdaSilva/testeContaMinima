package Informacoes;

import br.com.contaminima.ultrareader.RegistroChamada;

public class ChamadaInformacoes implements RegistroChamada {

    private String Data;
    private String Hora;
    private String Origem;
    private String Destino;
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
    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    @Override
    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }

    @Override
    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
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
