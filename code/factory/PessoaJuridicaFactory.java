package factory;

import java.util.List;

import pessoa.PessoaJuridica;

public interface PessoaJuridicaFactory {

	void insert(PessoaJuridica obj);
	PessoaJuridica read(String cpfOuCnpj);
	List<PessoaJuridica> readAll();
	void update(PessoaJuridica obj);
	void delete(String cpfOuCnpj);
}
