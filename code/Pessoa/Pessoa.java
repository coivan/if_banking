import java.util.Date;

public abstract class Pessoa {

	public String nome;
	public String endereco;
	public String email;
	public String telefone;
	public Date nascimento;

	public Pessoa(String nome, String endereco, String email, String telefone, Date nascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}
}
