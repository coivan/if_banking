package factory.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;
import dbConnection.DBException;
import factory.ContaFactory;
import strategy.ContaStrategy;

public class ContaFactoryJDBC implements ContaFactory {
private Connection connection;
	
	public ContaFactoryJDBC(Connection connection) {
		this.connection = connection;
	}
	
	//insere uma pessoa no banco de dados
	@Override
	public void insert(ContaStrategy obj) {
		
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(
					"INSERT INTO conta "
					+ "(numero, saldo, valor_saque, valor_cheque_especial, tipo_conta) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNumeroConta());
			st.setDouble(2, obj.getSaldo());
			st.setDouble(3, obj.getValorSaque());
			st.setDouble(4, obj.getValorChequeEspecial());
			st.setString(5, obj.getTipoConta());
			
			int numeroDeLinhasAfetadas = st.executeUpdate();
			
			if(numeroDeLinhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					String numeroConta = rs.getString(4);
					obj.setNumeroConta(numeroConta);
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
	public ContaStrategy read(String numero) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement(
					"SELECT * FROM conta WHERE numero = ?");
			st.setString(1, numero);
			rs = st.executeQuery();
			if(rs.next()) {
				ContaStrategy contaStrategy = new ContaStrategy();
				contaStrategy.setNumeroConta(rs.getString("numero"));
				contaStrategy.setSaldo(rs.getDouble("saldo"));
				contaStrategy.setValorSaque(rs.getDouble("valor_saque"));
				contaStrategy.setValorChequeEspecial(rs.getDouble("valor_cheque_especial"));
				contaStrategy.setTipoConta(rs.getString("tipo_conta"));
				return contaStrategy;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DBConnection.closeStatement(st);
			DBConnection.closeResultSet(rs);
		}
	}

	//lê todas as pessoa no banco de dados
	@Override
	public List<ContaStrategy> readAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("SELECT * FROM conta");
			rs = st.executeQuery();
			
			List<ContaStrategy> list = new ArrayList<>();
			
			while(rs.next()) {
				ContaStrategy contaStrategy = new ContaStrategy();
				contaStrategy.setNumeroConta(rs.getString("numero"));
				contaStrategy.setSaldo(rs.getDouble("saldo"));
				contaStrategy.setValorSaque(rs.getDouble("valor_saque"));
				contaStrategy.setValorChequeEspecial(rs.getDouble("valor_cheque_especial"));
				contaStrategy.setTipoConta(rs.getString("tipo_conta"));
				list.add(contaStrategy);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DBConnection.closeStatement(st);
			DBConnection.closeResultSet(rs);
		}
	}

	//atualiza os dados de uma pessoa no banco de dados
	@Override
	public void update(ContaStrategy obj) {
		
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(
					"UPDATE conta "
					+ "SET numero = ?, saldo = ?, valor_saque = ?, valor_cheque_especial = ?, "
					+ "tipo_conta = ? "
					+ "WHERE numero = ?");
			st.setString(1, obj.getNumeroConta());
			st.setDouble(2, obj.getSaldo());
			st.setDouble(3, obj.getValorSaque());
			st.setDouble(4, obj.getValorChequeEspecial());
			st.setString(5, obj.getTipoConta());
			st.setString(6, obj.getNumeroConta());
			st.executeUpdate();	
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DBConnection.closeStatement(st);
		}
	}

	//deleta dos dados de uma pessoa do banco de dados
	@Override
	public void delete(String numero) {
		
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("DELETE FROM conta WHERE numero = ?");
			st.setString(1, numero);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DBConnection.closeStatement(st);
		}
	}

}
