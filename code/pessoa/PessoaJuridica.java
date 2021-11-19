import java.util.Date;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	public Double salario;

	public PessoaJuridica(String nome, String endereco, String email, String cnpj, String telefone, Date nascimento) {
		super(nome, endereco, email, telefone, nascimento);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
