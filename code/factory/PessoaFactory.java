package factory;

import java.util.List;

import pessoa.PessoaFisica;

public interface PessoaFactory {

	void insert(PessoaFisica obj);
	PessoaFisica read(String cpfOuCnpj);
	List<PessoaFisica> readAll();
	void update(PessoaFisica obj);
	void delete(String cpfOuCnpj);
}
