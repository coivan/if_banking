package factory.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dbConnection.DBConnection;
import dbConnection.DBException;
import factory.PessoaFisicaFactory;
import pessoa.Pessoa;
import pessoa.PessoaFisica;

public class PessoaFisicaFactoryJDBC implements PessoaFisicaFactory {

	private Connection connection;
	
	public PessoaFisicaFactoryJDBC(Connection connection) {
		this.connection = connection;
	}
	
	//insere uma pessoa no banco de dados
	@Override
	public void insert(PessoaFisica obj) {
		
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(
					"INSERT INTO pessoa "
					+ "(nome, endereco, email, telefone, nascimento, cpfOuCnpj, salario) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEndereco());
			st.setString(3, obj.getEmail());
			st.setString(4, obj.getTelefone());
			st.setDate(5, new java.sql.Date(obj.getNascimento().getTime()));
			st.setString(6, obj.getCpf());
			st.setDouble(7, obj.getSalario());
			
			int numeroDeLinhasAfetadas = st.executeUpdate();
			
			if(numeroDeLinhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					String cpf = rs.getString(1);
					obj.setCpf(cpf);
				}
				DBConnection.closeResultSet(rs);
			}
			else {
				throw new DBException("Erro, nenhuma linha afetada");
			}
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DBConnection.closeStatement(st);
		}
	}

	//lê uma pessoa do banco de dados
	@Override
	public Pessoa read(String cpfOuCnpj) {
		
		return null;
	}

	//lê todas as pessoa no banco de dados
	@Override
	public List<Pessoa> readAll() {
		
		return null;
	}

	//atualiza os dados de uma pessoa no banco de dados
	@Override
	public void update(Pessoa obj) {
		
		
	}

	//deleta dos dados de uma pessoa do banco de dados
	@Override
	public void delete(String cpfOuCnpj) {
		
		
	}
}
