import java.util.Date;

public class PessoaFisica extends Pessoa {

	public String cpf;

	public PessoaFisica(String nome, String endereco, String email, String telefone, Date nascimento, String cpf) {
		super(nome, endereco, email, telefone, nascimento);
		this.cpf = cpf;
	}

	public double salario;
}
