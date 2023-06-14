package model;

import java.util.Date;

public class Pagamento {
	private final ETipoPagamento tipo;
	private final Date data;
	private final double valor;

	public Pagamento(ETipoPagamento tipo, double valor) {
		this.data = new Date();
		this.tipo = tipo;
		this.valor = valor;
	}

	public ETipoPagamento getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public enum ETipoPagamento {
		PIX("pagamento pix"), DEBITO("pagamento debito"), CREDITO("pagamento credito");

		final String descricao;

		ETipoPagamento(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
