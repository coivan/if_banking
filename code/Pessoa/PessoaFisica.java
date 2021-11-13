import java.util.Date;

public class PessoaFisica extends Pessoa {

	public String cpf;
	public Double salario;

	public PessoaFisica(String nome, String endereco, String email, String telefone, Date nascimento, String cpf) {
		super(nome, endereco, email, telefone, nascimento);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
