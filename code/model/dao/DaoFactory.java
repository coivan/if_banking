package model.dao;

import dbConnection.DBConnection;
import model.dao.implementations.ContaDaoJDBC;
import model.dao.implementations.PessoaFisicaDaoJDBC;
import model.dao.implementations.PessoaJuridicaDaoJDBC;

public class DaoFactory {

	public static PessoaFisicaDao createPessoaFisicaDao() {
		return new PessoaFisicaDaoJDBC(DBConnection.getConnection());
	}
	
	public static PessoaJuridicaDao createPessoaJuridicaDao() {
		return new PessoaJuridicaDaoJDBC(DBConnection.getConnection());
	}
	
	public static ContaDao createContaDao() {
		return new ContaDaoJDBC(DBConnection.getConnection());
	}
}
