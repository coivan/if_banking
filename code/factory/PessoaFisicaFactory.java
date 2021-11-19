package factory;

import java.util.List;

import pessoa.Pessoa;
import pessoa.PessoaFisica;

public interface PessoaFisicaFactory {

	void insert(PessoaFisica obj);
	Pessoa read(String cpfOuCnpj);
	List<Pessoa> readAll();
	void update(Pessoa obj);
	void delete(String cpfOuCnpj);
}
