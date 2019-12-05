package br.com.contaminima.ultrareader;

import Informacoes.ChamadaInformacoes;
import Informacoes.FaturaInforacoes;
import Informacoes.ServicoInformaoes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderFatura extends Reader {
    Matcher m;
    Double valor = 0.00;

    FaturaInforacoes faturaInformacoes = new FaturaInforacoes();
    List<RegistroChamada> listaChamadas = new ArrayList<>();
    List<RegistroServico> listaServico = new ArrayList<>();

    @Override
    public boolean execute() {
        m = Pattern.compile("(\\d{2}\\/\\d{2}\\/\\d{4})").matcher(fullText);
        if (m.find()) {
            faturaInformacoes.setDataReferencia(m.group(1));
        }
        m = Pattern.compile("(\\d{8})").matcher(fullText);
        if (m.find()) {
            faturaInformacoes.setContrato(m.group(1));
        }
        m = Pattern.compile("(\\w{5}\\ \\w{11})").matcher(fullText);
        if (m.find()) {
            faturaInformacoes.setNomeCliente(m.group(1));
        }
        m = Pattern.compile("(\\d+\\,\\d+)").matcher(fullText);
        if (m.find()) {
            faturaInformacoes.setTotalInformado(Double.parseDouble(m.group(1).replaceAll(",", ".")));
        }
        m = Pattern.compile("(\\d+\\,\\d+)").matcher(fullText);
        if (m.find()) {
            faturaInformacoes.setTotalLido(Double.parseDouble(m.group(1).replaceAll(",", ".")));
        }

        String[] strings = fullText.split("\n");
        for (String s : strings) {
            ChamadaInformacoes chamadaInformacoes = new ChamadaInformacoes();
            m = Pattern.compile("((\\d+\\/\\d+\\/\\d+)\\s(\\d+:\\d+)\\s(\\d+-\\d+-\\d+)\\s(\\d+-\\d+-\\d+)\\s(\\D+)\\s(\\d+,\\d+))").matcher(s);
            if (m.find()) {
                chamadaInformacoes.setData(m.group(2));
                chamadaInformacoes.setHora(m.group(3));
                chamadaInformacoes.setOrigem(m.group(4).replaceAll("-", ""));
                chamadaInformacoes.setDestino(m.group(5).replaceAll("-", ""));
                chamadaInformacoes.setDescricao(m.group(6));
                chamadaInformacoes.setValor(Double.parseDouble(m.group(7).replaceAll(",", ".")));
                valor += (Double.parseDouble(m.group(7).replaceAll(",", ".")));
                this.listaChamadas.add(chamadaInformacoes);
            }
        }
        faturaInformacoes.setChamadas(listaChamadas);

        for (String s : strings) {
            ServicoInformaoes servicoInformaoes = new ServicoInformaoes();
            m = Pattern.compile("((\\d+\\/\\d+\\/\\d+)\\s(\\d+-\\d+-\\d+)\\s(\\w+\\s\\w+\\s?\\w+)\\s(\\d+,\\d+))").matcher(s);
            if (m.find()) {
                servicoInformaoes.setData(m.group(2));
                servicoInformaoes.setOrigem((m.group(3).replaceAll("-", "")));
                servicoInformaoes.setDescricao(m.group(4));
                servicoInformaoes.setValor(Double.parseDouble(m.group(5).replaceAll(",", ".")));
                valor += (Double.parseDouble(m.group(5).replaceAll(",", ".")));
                this.listaServico.add(servicoInformaoes);
            }
        }
        faturaInformacoes.setServicos(listaServico);
        faturaInformacoes.setTotalLido(valor);

        valor = 0.0;
        this.fatura = faturaInformacoes;
        return true;
    }
}


