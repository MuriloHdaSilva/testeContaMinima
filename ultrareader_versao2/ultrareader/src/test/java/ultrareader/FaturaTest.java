package ultrareader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Informacoes.FaturaInforacoes;
import br.com.contaminima.ultrareader.Reader;
import br.com.contaminima.ultrareader.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FaturaTest {
	private Fatura fatura;
	private List<String> outrasFaturas;
	private static final String FILE_PATH = "/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura.txt"; //TODO Setar o caminho do arquivo


	@Before
	public void setUp() throws IOException {
		Reader reader = new ReaderFatura(); //TODO Instanciar o leitor
		reader.load(new File(FILE_PATH));
		reader.execute();
		this.fatura = reader.getFatura();


		outrasFaturas = new ArrayList<>();
		outrasFaturas.add("/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura_2.txt"); //TODO Setar o caminho do arquivo
		outrasFaturas.add("/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura_3.txt"); //TODO Setar o caminho do arquivo
		outrasFaturas.add("/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura_4.txt"); //TODO Setar o caminho do arquivo
		outrasFaturas.add("/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura_5.txt"); //TODO Setar o caminho do arquivo
		outrasFaturas.add("/home/murilo/Downloads/project/ultrareader_faturas/ultra_fatura_windows.txt"); //TODO Setar o caminho do arquivo
	}

	//-Informações de Cabeçalho------------------------------------------//

	@Test
	public void dataReferencia() {
		Assert.assertEquals("02/04/2018", fatura.getDataReferencia());
	}

	@Test
	public void contrato() {
		Assert.assertEquals("13572468", fatura.getContrato());
	}

	@Test
	public void cliente() {
		Assert.assertEquals("Wayne Enterprises", fatura.getNomeCliente());
	}

	@Test
	public void totalInformado() {
		Assert.assertEquals(Double.parseDouble("144.24"), fatura.getTotalInformado(), 0d);
	}

	//-Informações dos Registros Telefônicos-----------------------------//

	@Test
	public void quantidadeRegistros() {
		Assert.assertEquals(Integer.parseInt("10"), fatura.getChamadas().size());
		Assert.assertEquals(Integer.parseInt("2"), fatura.getServicos().size());
	}

	@Test
	public void totalLido() {
		Assert.assertEquals(Double.parseDouble("144.24"), fatura.getTotalLido(), 0.01);
	}

	@Test
	public void registro0() {
		RegistroChamada registro = fatura.getChamadas().get(0);
		Assert.assertEquals("12/11/1955", registro.getData());
		Assert.assertEquals("22:03", registro.getHora());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("4832654756", registro.getDestino());
		Assert.assertEquals("Chamada Local", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("15.32"), registro.getValor(), 0d);
	}

	@Test
	public void chamada1() {
		RegistroChamada registro = fatura.getChamadas().get(1);
		Assert.assertEquals("15/11/1955", registro.getData());
		Assert.assertEquals("02:13", registro.getHora());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("4899857596", registro.getDestino());
		Assert.assertEquals("Chamada Local para Outros Celulares", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("4.17"), registro.getValor(), 0d);
	}

	@Test
	public void chamada5() {
		RegistroChamada registro = fatura.getChamadas().get(5);
		Assert.assertEquals("23/11/1955", registro.getData());
		Assert.assertEquals("11:26", registro.getHora());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("4898879841", registro.getDestino());
		Assert.assertEquals("Chamada Local Utilizando plano", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("0.0"), registro.getValor(), 0d);
	}

	@Test
	public void chamada6() {
		RegistroChamada registro = fatura.getChamadas().get(6);
		Assert.assertEquals("02/11/1955", registro.getData());
		Assert.assertEquals("19:40", registro.getHora());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("4732654756", registro.getDestino());
		Assert.assertEquals("Chamada de Longa Distância", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("35.03"), registro.getValor(), 0d);
	}

	@Test
	public void chamada9() {
		RegistroChamada registro = fatura.getChamadas().get(9);
		Assert.assertEquals("27/11/1955", registro.getData());
		Assert.assertEquals("06:51", registro.getHora());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("4733481756", registro.getDestino());
		Assert.assertEquals("Chamada Especial com tarifa reduzida", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("0.57"), registro.getValor(), 0d);
	}

	@Test
	public void servico0() {
		RegistroServico registro = fatura.getServicos().get(0);
		Assert.assertEquals("05/11/1955", registro.getData());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("Pacote de torpedos", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("9.99"), registro.getValor(), 0d);
	}

	@Test
	public void servico1() {
		RegistroServico registro = fatura.getServicos().get(1);
		Assert.assertEquals("08/11/1955", registro.getData());
		Assert.assertEquals("4891475632", registro.getOrigem());
		Assert.assertEquals("Internet 4G", registro.getDescricao());
		Assert.assertEquals(Double.parseDouble("25.99"), registro.getValor(), 0d);
	}

	//-Outras Faturas (Totais)-------------------------------------------//

	@Test
	public void outrasFaturasTotais() throws IOException {
		Reader reader = new ReaderFatura(); //TODO Instanciar o leitor
		for (String file : outrasFaturas) {
			reader.load( new File(file) );
			try {
				reader.execute();
				Fatura f = reader.getFatura();
				Assert.assertEquals(f.getTotalInformado(), f.getTotalLido(), 0.01);
			} catch(Exception e) {
				System.err.println("[Erro] Arquivo de fatura: " + file);
				throw e;
			}
		}
	}

}