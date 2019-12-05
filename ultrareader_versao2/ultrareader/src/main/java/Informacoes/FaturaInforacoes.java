package Informacoes;

import br.com.contaminima.ultrareader.Fatura;
import br.com.contaminima.ultrareader.RegistroChamada;
import br.com.contaminima.ultrareader.RegistroServico;

import java.util.List;

public class FaturaInforacoes implements Fatura {
    private String DataReferencia;
    private String Contrato;
    private String NomeCliente;
    private Double TotalInformado;
    private Double TotalLido;
    private List<RegistroChamada> Chamadas;
    private List<RegistroServico> Servicos;

    @Override
    public String getDataReferencia() {
        return DataReferencia;
    }

    public void setDataReferencia(String dataReferencia) {
        DataReferencia = dataReferencia;
    }
    @Override
    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String contrato) {
        Contrato = contrato;
    }

    @Override
    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        NomeCliente = nomeCliente;
    }

    @Override
    public Double getTotalInformado() {
        return TotalInformado;
    }

    public void setTotalInformado(Double totalInformado) {
        TotalInformado = totalInformado;
    }

    @Override
    public Double getTotalLido() {
        return TotalLido;
    }

    public void setTotalLido(Double totalLido) {
        TotalLido = totalLido;
    }

    @Override
    public List<RegistroChamada> getChamadas() {
        return Chamadas;
    }

    public void setChamadas(List<RegistroChamada> chamadas) {
        Chamadas = chamadas;
    }

    @Override
    public List<RegistroServico> getServicos() {
        return Servicos;
    }

    public void setServicos(List<RegistroServico> servicos) {
        Servicos = servicos;
    }
}
