package factory;

import dbConnection.DBConnection;
import factory.implementations.PessoaFisicaFactoryJDBC;

public class DBConectionFactory {

	public static PessoaFactory createPessoaFactory() {
		return new PessoaFisicaFactoryJDBC(DBConnection.getConnection());
	}
}
