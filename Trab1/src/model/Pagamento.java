package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Pagamento implements Serializable{
	private static final long serialVersionUID = -1119751179085551545L;
	private final ETipoPagamento tipo;
	private final LocalDateTime data;
	private final double valor;

	public Pagamento(ETipoPagamento tipo, double valor) {
		if(valor < 0.01) {
			throw new IllegalArgumentException("Valor inválido.");
		}
		this.data = LocalDateTime.now();
		this.tipo = tipo;
		this.valor = valor;
	}

	public ETipoPagamento getTipo() {
		return tipo;
	}

	public LocalDateTime getData() {
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
