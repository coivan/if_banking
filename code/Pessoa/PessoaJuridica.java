import java.util.Date;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;

	public PessoaJuridica(String nome, String endereco, String email, String cnpj, String telefone, Date nascimento) {
		super(nome, endereco, email, telefone, nascimento);
		this.cnpj = cnpj;
	}

	public double salario;
}
