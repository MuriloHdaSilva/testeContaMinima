package br.com.contaminima.ultrareader;

import Informacoes.FaturaInforacoes;
import br.com.contaminima.ultrareader.Fatura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Reader {
	protected Fatura fatura;
	protected String fullText;

	public boolean load(File file) throws IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new FileReader(file));
		while (br.ready()) {
			sb.append(br.readLine());
			sb.append("\n");
		}
		br.close();

		String fullText = sb.toString();
		if (fullText.isEmpty())
			return false;

		this.fullText = fullText;
		return true;
	}

	public abstract boolean execute();


	public final Fatura getFatura() {
		return fatura;

	}


}