package model;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable{
	private static final long serialVersionUID = -1119751179085551545L;
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
		PIX("Pagamento Pix"), DEBITO("Dagamento Debito"), CREDITO("Pagamento Credito");

		private final String descricao;

		ETipoPagamento(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
