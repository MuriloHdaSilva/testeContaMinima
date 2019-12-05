package br.com.contaminima.ultrareader;

import java.util.List;

public interface Fatura {

	public String getDataReferencia();


	public String getContrato();

	public String getNomeCliente();

	/**
	 * Retorna o valor total informado no cabeçalho da fatura
	 * */
	public Double getTotalInformado();

	/**
	 * Retorna o valor total calculado a partir do somatório dos registros lidos
	 * */
	public Double getTotalLido();

	public List<RegistroChamada> getChamadas();

	public List<RegistroServico> getServicos();

}