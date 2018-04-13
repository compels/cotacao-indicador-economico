package net.compels.cotacao.entity;

/**
 * @author Alessandro Bruno Lima
 *
 *         12 de abr de 2018
 *
 *         Representa um indice de consulta de valores no Banco Central do Brasil.
 * 
 *         Para ver o indice completo de moedas suportadas, veja o arquivo indices.txt na pasta resources.
 * 
 *         Esse arquivo foi tirado de: http://egas.digital/cotacoes.txtAtualizad
 */
public enum Indice {

	// moedas
	DOLAR_VENDA(1, "Dólar (venda)"), DOLAR_COMPRA(10813, "Dólar (compra)"), EURO_VENDA(21619, "Euro (venda)"), EURO_COMPRA(21620, "Euro (compra)");

	private final long codigo;

	private final String descricao;

	Indice(final long codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Indice{");
		sb.append("codigo=").append(codigo);
		sb.append(", descricao='").append(descricao).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public static Indice getIndiceByCodigo(long codigo) {
		for (int i = 0; i < Indice.values().length; i++) {
			if (codigo == Indice.values()[i].codigo)
				return Indice.values()[i];
		}
		return null;
	}
}