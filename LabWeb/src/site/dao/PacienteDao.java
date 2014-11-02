package site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import site.vo.Exame;
import site.vo.Paciente;


public class PacienteDao extends Dao {

	public Paciente getPaciente(int idPaciente)
	{
		Connection conn = null;
		
		try
		{
			conn = getConnection();

			String sql = "SELECT a.id_paciente, a.cod_verif, a.nome_paciente, a.rg_paciente, a.cpf_paciente, a.datanasc_paciente, a.endereco_rua, a.endereco_num, a.endereco_bairro, a.cep, a.telefone_paciente, a.email_paciente, a.convenio_paciente, n.id_exame, n.descricao FROM paciente a INNER JOIN exame n ON a.id_paciente = n.id_paciente WHERE a.id_paciente = ?";        

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPaciente);
			ResultSet result = stmt.executeQuery();

			if (result.next())
			{
				Paciente paciente = new Paciente();
				paciente.setId(result.getInt("id_paciente"));
				paciente.setCod_verif(result.getInt("cod_verif"));
				paciente.setNome_paciente(result.getString("nome_paciente"));
				paciente.setRg_paciente(result.getString("rg_paciente"));
				paciente.setCpf_paciente(result.getString("cpf_paciente"));
				paciente.setDatanasc_paciente(result.getString("datanasc_paciente"));
				paciente.setEndereco_rua(result.getString("endereco_rua"));
				paciente.setEndereco_num(result.getInt("endereco_num"));
				paciente.setEndereco_bairro(result.getString("endereco_bairro"));
				paciente.setCep(result.getString("cep"));
				paciente.setTelefone_paciente(result.getString("telefone_paciente"));
				paciente.setEmail_paciente(result.getString("email_paciente"));
				paciente.setConvenio_paciente(result.getString("convenio_paciente"));

				Exame exame = new Exame();
				exame.setId(result.getInt("id_exame"));
				exame.setDescricao(result.getString("descricao"));
				paciente.setExame(exame);

				return paciente;
			}
			else
			{
				return null;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}
	}
	
	public List<Paciente> getPacientes()
	{
		Connection conn = null;
		List<Paciente> pacientes = new ArrayList<Paciente>();

		try
		{
			conn = getConnection();

			String sql = "SELECT a.id_paciente, a.cod_verif, a.nome_paciente, a.rg_paciente, a.cpf_paciente, a.datanasc_paciente, a.endereco_rua, a.endereco_num, a.endereco_bairro, a.cep, a.telefone_paciente, a.email_paciente, a.convenio_paciente, n.id_exame, n.descricao FROM paciente a INNER JOIN exame n ON a.id_paciente = n.id_paciente";        

			PreparedStatement stmt = conn.prepareStatement(sql);      
			ResultSet result = stmt.executeQuery();

			while (result.next())
			{
				Paciente paciente = new Paciente();
				paciente.setId(result.getInt("id_paciente"));
				paciente.setCod_verif(result.getInt("cod_verif"));
				paciente.setNome_paciente(result.getString("nome_paciente"));
				paciente.setRg_paciente(result.getString("rg_paciente"));
				paciente.setCpf_paciente(result.getString("cpf_paciente"));
				paciente.setDatanasc_paciente(result.getString("datanasc_paciente"));
				paciente.setEndereco_rua(result.getString("endereco_rua"));
				paciente.setEndereco_num(result.getInt("endereco_num"));
				paciente.setEndereco_bairro(result.getString("endereco_bairro"));
				paciente.setCep(result.getString("cep"));
				paciente.setTelefone_paciente(result.getString("telefone_paciente"));
				paciente.setEmail_paciente(result.getString("email_paciente"));
				paciente.setConvenio_paciente(result.getString("convenio_paciente"));

				Exame exame = new Exame();
				exame.setId(result.getInt("id_exame"));
				exame.setDescricao(result.getString("descricao"));
				paciente.setExame(exame);

				pacientes.add(paciente);
			}

			return pacientes;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}
	}

	public boolean insertPaciente(Paciente paciente)
	{
		Connection conn = null;

		try
		{
			//obtem conexao com o banco de dados
			conn = getConnection();
			conn.setAutoCommit(false);

			//define SQL para inser��o
			String sql = "insert into paciente (cod_verif, nome_paciente, rg_paciente, cpf_paciente, datanasc_paciente, endereco_rua, endereco_num, endereco_bairro, cep, telefone_paciente, email_paciente, convenio_paciente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";        

			//instance Prepared statement especificando os par�metros do SQL
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, paciente.getCod_verif());
			stmt.setString(2, paciente.getNome_paciente());
			stmt.setString(3, paciente.getRg_paciente());
			stmt.setString(4, paciente.getCpf_paciente());
			stmt.setString(5, paciente.getDatanasc_paciente());
			stmt.setString(6, paciente.getEndereco_rua());
			stmt.setInt(7, paciente.getEndereco_num());
			stmt.setString(8, paciente.getEndereco_bairro());
			stmt.setString(9, paciente.getCep());
			stmt.setString(10, paciente.getTelefone_paciente());
			stmt.setString(11, paciente.getEmail_paciente());
			stmt.setString(12, paciente.getConvenio_paciente());

			//executa a opera��o no banco de dados
			int affectedRows = stmt.executeUpdate();

			//verifica se deu certo. Se sim, obtem a chave gerada 
			if (affectedRows > 0)
			{  
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();

				//obtem a chave no resultado da inser��o
				//1 indica primeira coluna no resultado vindo do banco de dados
				paciente.setId(rs.getInt(1));

				//obtem valor e cria sql para inserir valor
				Exame exame = paciente.getExame();
				sql = "insert into exame (id_paciente, descricao) values (?, ?);";        

				stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, paciente.getId());
				stmt.setString(2, exame.getDescricao());
			

				affectedRows = stmt.executeUpdate();
				if (affectedRows > 0)
				{
					rs = stmt.getGeneratedKeys();
					rs.next();
					//obtem a chave no resultado da inser��o
					//1 indica primeira coluna no resultado vindo do banco de dados
					exame.setId(rs.getInt(1));
				}
				else
				{
					//cancela as modifica��es no banco de dados
					conn.rollback();
					return false;
				}
				//confirma as modifica��es no banco de dados
				conn.commit();        
				return true;
			}        
			//cancela as modifica��es no banco de dados
			conn.rollback();
			return false;

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}    
	}

	public boolean updatePaciente(Paciente paciente)
	{
		Connection conn = null;

		try
		{
			//obtem conexao com o banco de dados
			conn = getConnection();
			conn.setAutoCommit(false);

			//define SQL para atualiza��o
			String sql = "UPDATE paciente SET cod_verif=?, nome_paciente=?, rg_paciente=?, cpf_paciente=?, datanasc_paciente=?, endereco_rua=?, endereco_num=?, endereco_bairro=?, cep=?, telefone_paciente=?, email_paciente=?, convenio_paciente=? WHERE id_paciente=?";        

			//instance Prepared statement especificando os par�metros do SQL
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, paciente.getCod_verif());
			stmt.setString(2, paciente.getNome_paciente());
			stmt.setString(3, paciente.getRg_paciente());
			stmt.setString(4, paciente.getCpf_paciente());
			stmt.setString(5, paciente.getDatanasc_paciente());
			stmt.setString(6, paciente.getEndereco_rua());
			stmt.setInt(7, paciente.getEndereco_num());
			stmt.setString(8, paciente.getEndereco_bairro());
			stmt.setString(9, paciente.getCep());
			stmt.setString(10, paciente.getTelefone_paciente());
			stmt.setString(11, paciente.getEmail_paciente());
			stmt.setString(12, paciente.getConvenio_paciente());
			stmt.setInt(13, paciente.getId());

			//executa a opera��o no banco de dados
			int affectedRows = stmt.executeUpdate();

			//verifica se deu certo. Se sim, atualiza a valor 
			if (affectedRows > 0)
			{  
				//obtem valor e cria sql para atualizar a valor
				Exame exame = paciente.getExame();
				sql = "UPDATE exame SET descricao=? WHERE id_exame=?";        

				stmt = conn.prepareStatement(sql);
				
				//o campo decimal do Banco de Dados � representado em Java por BigDecimal
				stmt.setString(1, exame.getDescricao());
				stmt.setInt(2, exame.getId());

				affectedRows = stmt.executeUpdate();
				if (affectedRows > 0)
				{
					//confirma as modifica��es no banco de dados
					conn.commit();
					return true;
				}
				else
				{
					//cancela as modifica��es no banco de dados
					conn.rollback();
					return false;
				}				
			}        
			
			//cancela as modifica��es no banco de dados
			conn.rollback();
			return false;

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}    
	}

	public boolean deletePaciente(int idPaciente)
	{
		Connection conn = null;

		try
		{
			//obtem conexao com o banco de dados
			conn = getConnection();

			//define SQL para atualiza��o
						
			String sql= "DELETE FROM paciente WHERE id_paciente=? ";
		     

			//instance Prepared statement especificando os par�metros do SQL
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPaciente);

			//executa a opera��o no banco de dados
			return stmt.executeUpdate() > 0;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				}
				catch(Exception closeEx)
				{
					//do nothing
				}
			}
		}    
	}

}