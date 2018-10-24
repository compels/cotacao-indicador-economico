package net.compels.cotacao.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.compels.cotacao.entity.Cotacao;
import net.compels.cotacao.entity.Indice;

/**
 * @author Alessandro Bruno Lima
 *
 *         12 de abr de 2018
 */
public class Teste {

	public static void main(String[] args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date date = sdf.parse("02/10/2018");
		Date date2 = sdf.parse("23/10/2018");

		List<Cotacao> cotacaoIndicadorEconomicoList = new WSConsulta().getCotacaoPeriodo(Indice.getIndiceByCodigo(1), date, date2);

		if (cotacaoIndicadorEconomicoList != null && !cotacaoIndicadorEconomicoList.isEmpty()) {
			for (Cotacao cotacaoIndicadorEconomico : cotacaoIndicadorEconomicoList) {
				System.err.println("----------------------------------------------------");
				System.err.println("Data: " + cotacaoIndicadorEconomico.getData().toString());
				System.err.println("Valor: " + cotacaoIndicadorEconomico.getValor().toString());
			}
		}

	}

}
