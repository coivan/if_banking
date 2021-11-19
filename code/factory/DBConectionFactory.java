package factory;

import dbConnection.DBConnection;
import factory.implementations.PessoaFisicaFactoryJDBC;

public class DBConectionFactory {

	public static PessoaFisicaFactory createPessoaFactory() {
		return new PessoaFisicaFactoryJDBC(DBConnection.getConnection());
	}
}
