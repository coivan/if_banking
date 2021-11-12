import java.util.Date;

public class Gerente extends PessoaFisica {

	private Integer id;

	public Gerente(String nome, String endereco, String email, String telefone, Date nascimento, String cpf, Integer id) {
		super(nome, endereco, email, telefone, nascimento, cpf);
		this.id = id;
	}

	public void fechar_conta() {

	}

	public void consultar_credito() {

	}

}
