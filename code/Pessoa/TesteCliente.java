import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteCliente {
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		PessoaFisica pessoaFisica = new PessoaFisica("Pablo Escobar", "Rua do Pó", "elguaco@pbe.noia", "(123)9999-8888", sdf.parse("01/01/1981"), "111.222.333-44");
		System.out.println("\nNome: " + pessoaFisica.nome);
		System.out.println("Endereco: " + pessoaFisica.endereco);
		System.out.println("Email: " + pessoaFisica.email);
		System.out.println("Telefone: " + pessoaFisica.telefone);
		System.out.println("CPF: " + pessoaFisica.cpf);
		System.out.println("Data de nascimento: " + pessoaFisica.getNascimento());
	}
}