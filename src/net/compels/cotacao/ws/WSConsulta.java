package net.compels.cotacao.ws;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.compels.cotacao.entity.Cotacao;
import net.compels.cotacao.entity.Indice;
import net.compels.cotacao.ws.comum.WSSerieVO;
import net.compels.cotacao.ws.comum.WSValorSerieVO;
import net.compels.cotacao.ws.servicos.FachadaWSSGS;
import net.compels.cotacao.ws.servicos.FachadaWSSGSProxy;

/**
 * @author Alessandro Bruno Lima
 *
 *         12 de abr de 2018
 */

public class WSConsulta {

	private static final FachadaWSSGS FACHADA = new FachadaWSSGSProxy();

	private SimpleDateFormat sdfPadraoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public Cotacao getCotacaoData(final Indice indice, final Date data) {
		try {
			final BigDecimal valor = FACHADA.getValor(indice.getCodigo(), getDataPadraoBrasileiro(data));
			return new Cotacao(data, indice, valor.doubleValue());
		} catch (RemoteException e) {
			return null;
		}
	}

	public List<Cotacao> getCotacaoPeriodo(final Indice indice, final Date dataInicio, final Date dataFim) throws RemoteException, ParseException {

		final long[] moedas = { indice.getCodigo() };
		WSSerieVO[] wsServiceVO = FACHADA.getValoresSeriesVO(moedas, getDataPadraoBrasileiro(dataInicio), getDataPadraoBrasileiro(dataFim));

		if (wsServiceVO == null || wsServiceVO.length == 0)
			return null;

		final List<Cotacao> cotacoes = new ArrayList<Cotacao>();
		for (WSValorSerieVO valorSerieVO : wsServiceVO[0].getValores()) {
			String dia = String.format("%0" + 2 + "d", valorSerieVO.getDia());
			String mes = String.format("%0" + 2 + "d", valorSerieVO.getMes());
			String ano = String.valueOf(valorSerieVO.getAno());
			final String date = ano + mes + dia;
			cotacoes.add(new Cotacao(getData(date), indice, valorSerieVO.getValor().doubleValue()));
		}
		return cotacoes;
	}

	private String getDataPadraoBrasileiro(Date data) {
		return sdfPadraoBrasileiro.format(data);
	}

	private java.sql.Date getData(String data) {
		try {
			return new java.sql.Date(sdf.parse(data).getTime());
		} catch (Exception e) {
			return null;
		}
	}

}
