package br.com.asantos.gerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Categoria;

public class CategoriaDao extends BaseDao {

//	private Connection connection;
//	
//	public CategoriaDao(Connection connection) {
//		this.connection = connection;
//	}
//	
//	ConnectionFactory criaConexao = new ConnectionFactory();
//	Connection connection = criaConexao.recuperarConexão();

	public ArrayList<Categoria> getCategorias() throws Exception {
		open();

		ArrayList<Categoria> lst = new ArrayList<>();
		// prepara o statement, devolve um boolean
		Statement stm = getConn().createStatement();
		// o resultado é recuperado em um result set
		// boolean result = stm.execute("SELECT cat_id, cat_nome FROM categoria");
		// ResultSet rst = stm.getResultSet();

		String sql = "SELECT cat_id, cat_nome, cat_codigo FROM categoria";
		ResultSet rst = stm.executeQuery(sql);
		while (rst.next()) {
			Categoria cat = new Categoria();
			cat.setId(rst.getInt(1));
			cat.setNome(rst.getString(2));
			cat.setCodigoCategoria(rst.getInt(3));
			lst.add(cat);
		}
		stm.close();
		rst.close();
		return lst;

	}

	public ArrayList<Categoria> findCategorias(String nome) throws Exception {
		super.open();
		ArrayList<Categoria> lst = new ArrayList<>();
		String sql = "SELECT cat_id, cat_nome FROM categoria where cat_nome like ?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Categoria cat = new Categoria();
			cat.setId(Integer.parseInt(rs.getString(1)));
			cat.setNome(rs.getString(2));
			lst.add(cat);
		}
		pstm.close();
		rs.close();
		close();
		return lst;
	}

	public void newcategoria(Categoria categoria) throws Exception {
		open();
		String query = " INSERT INTO categoria (cat_nome, cat_codigo)" + " values (?, ?)";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, categoria.getNome());
		pstm.setInt(2, categoria.getCodigoCategoria());
		pstm.execute();
		close();
	}

	public void editCategoria(Categoria categoria) throws Exception {
		open();
		String query = " UPDATE categoria SET cat_nome=?, cat_codigo=? where cat_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, categoria.getNome());
		pstm.setInt(2, categoria.getCodigoCategoria());
		pstm.setInt(3, categoria.getId());
		pstm.execute();
		close();
	}
	
	public void deleteCategoria(Categoria categoria) throws Exception {
		//abre conexão cm o DB, lá da BaseDAO
		open();
		//monta a query com o comando que desejamos
		String query = "DELETE FROM categoria where cat_id=?";
		//compõe o statement usando a conexão e passando o comando sql
		PreparedStatement pstm = getConn().prepareStatement(query);
		//passa pro statement o id refernte ao que queremos
		pstm.setInt(1, categoria.getId());
		//executa a ação do sql
		pstm.execute();
		//encerra a transaçaõ
		pstm.close();
		//fecha a conexão cm o bd
		close();
	}
	
	public Categoria findByIdCategoria(int id) throws Exception{
		super.open();
	
		String sql = "SELECT cat_id, cat_nome, cat_codigo FROM categoria WHERE cat_id=?";
		
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setInt(1,  id);
		
		ResultSet rs = pstm.executeQuery();
		
		Categoria cat = new Categoria();
		while(rs.next()) {
			cat.setId(Integer.parseInt(rs.getString(1)));
			cat.setNome(rs.getString(2));
			cat.setCodigoCategoria(rs.getInt(3));
		}
		rs.close();
		return cat;
	}

}
