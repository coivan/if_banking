package factory;

import dbConnection.DBConnection;
import factory.implementations.PessoaFisicaFactoryJDBC;
import factory.implementations.PessoaJuridicaFactoryJDBC;

public class DBConectionFactory {

	public static PessoaFisicaFactory createPessoaFisicaFactory() {
		return new PessoaFisicaFactoryJDBC(DBConnection.getConnection());
	}
	
	public static PessoaJuridicaFactory createPessoaJuridicaFactory() {
		return new PessoaJuridicaFactoryJDBC(DBConnection.getConnection());
	}
}
