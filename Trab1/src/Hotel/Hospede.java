package Hotel;

public class Hospede implements IHospede {

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
	public String getEmail() {
		return email;
	}

	@Override
	public long getTelefone() {
		return telefone;
	}

}
