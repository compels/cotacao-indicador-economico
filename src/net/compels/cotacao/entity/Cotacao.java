package net.compels.cotacao.entity;

import java.util.Date;

@SuppressWarnings("unused")
public class Cotacao {

	private final Indice indice;
	private final Date data;
	private final Double valor;

	public Cotacao(final Date data, final Indice indice, final Double valor) {
		this.data = data;
		this.indice = indice;
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	private Indice getIndice() {
		return indice;
	}

	public Double getValor() {
		return valor;
	}

}