package model;

import java.io.Serializable;

public class Hospede implements IHospede, Serializable {
	private static final long serialVersionUID = 3193785960528259305L;
	private final long cpf;
	private String nome;
	private String email;
	private long telefone;

	public Hospede(long cpf, String nome, String email, long telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	@Override
	public long getCpf() {
		return cpf;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	@Override
	public long getTelefone() {
		return telefone;
	}

}
