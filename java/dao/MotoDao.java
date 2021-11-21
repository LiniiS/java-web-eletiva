package br.com.asantos.gerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Moto;

/**
 * Classe que simula um Banco de Dados para a classe Moto contem uma lista
 * pré-pronta dos itens e possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.2
 */
public class MotoDao extends BaseDao {

	public ArrayList<Moto> getMotos() throws Exception {
		open();

		ArrayList<Moto> lst = new ArrayList<>();
		Statement stm = getConn().createStatement();

		String sql = "SELECT mto_id, mto_marca, mto_placa, mto_cilindrada FROM moto";
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			Moto mto = new Moto();
			mto.setId(rs.getInt(1));
			mto.setMarcaVeiculo(rs.getString(2));
			mto.setPlacaVeiculo(rs.getString(3));
			mto.setCilindradaMoto(rs.getInt(4));

			lst.add(mto);
		}
		stm.close();
		rs.close();
		close();

		return lst;

	}

	public ArrayList<Moto> findMotos(String marca) throws Exception {
		super.open();
		ArrayList<Moto> lst = new ArrayList<>();
		String sql = "SELECT mto_id, mto_marca, mto_placa, mto_cilindrada FROM moto where mto_marca like ?";
		PreparedStatement pstm = getConn().prepareStatement(sql);
		pstm.setString(1, marca + '%');
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Moto mto = new Moto();
			mto.setId(Integer.parseInt(rs.getString(1)));
			mto.setMarcaVeiculo(rs.getString(2));
			mto.setPlacaVeiculo(rs.getString(3));
			mto.setCilindradaMoto(Integer.parseInt(rs.getString(4)));

			lst.add(mto);
		}
		pstm.close();
		rs.close();
		close();
		return lst;

	}
	
	public void newMoto(Moto moto) throws Exception{
		open();
		//									1			2			3			4				5
		String query = "INSERT INTO moto (mto_marca, mto_marcha, mto_placa, mto_velocidade, mto_cilindrada) values (?,?,?,?,?)";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, moto.getMarcaVeiculo());
		pstm.setInt(2, moto.getMarchaVeiculo());
		pstm.setString(3, moto.getPlacaVeiculo());
		pstm.setInt(4, moto.getVelocidadeVeiculo());
		pstm.setInt(5, moto.getCilindradaMoto());
		pstm.execute();
		close();
	}
	
	public void editMoto(Moto moto) throws Exception{
		open();
		String query = "UPDATE moto SET mto_marca=?, mto_marcha=?, mto_placa=?, mto_velocidade=?, mto_cilindrada=? WHERE mto_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setString(1, moto.getMarcaVeiculo());
		pstm.setInt(2, moto.getMarchaVeiculo());
		pstm.setString(3, moto.getPlacaVeiculo());
		pstm.setInt(4, moto.getVelocidadeVeiculo());
		pstm.setInt(5, moto.getCilindradaMoto());
		pstm.setInt(6, moto.getId());
		pstm.execute();
		close();
	}
	public void deleteMoto(Moto moto) throws Exception{
		open();
		String query = "DELETE FROM moto WHERE mto_id=?";
		PreparedStatement pstm = getConn().prepareStatement(query);
		pstm.setInt(1, moto.getId());
		pstm.execute();
		pstm.close();
		close();
	}
	
	//esse findById tem que trazer todos os dados pois será usado no formulário de alteração de dados
	public Moto findByIdMoto(int id) throws Exception{
		 super.open();
		 String sql = "SELECT mto_id, mto_marca, mto_marcha, mto_placa, mto_velocidade, mto_cilindrada FROM moto WHERE mto_id=?";
		 PreparedStatement pstm = getConn().prepareStatement(sql);
		 pstm.setInt(1, id);
		 
		 ResultSet rs = pstm.executeQuery();
		 Moto mto = new Moto();
		 while(rs.next()) {
			 mto.setId(Integer.parseInt(rs.getString(1)));
			 mto.setMarcaVeiculo(rs.getString(2));
			 mto.setMarchaVeiculo(Integer.parseInt(rs.getString(3)));
			 mto.setPlacaVeiculo(rs.getString(4));
			 mto.setVelocidadeVeiculo(Integer.parseInt(rs.getString(5)));
			 mto.setCilindradaMoto(Integer.parseInt(rs.getString(6)));
		 }
		 rs.close();
		 return mto;
	}

}
/*
 * 
 * private static List<Moto> lista = new ArrayList<>(); private static Integer
 * id = 1;
 * 
 * static { Moto m1 = new Moto(); m1.setId(id++); m1.setCilindradaMoto(1500);
 * m1.setMarchaVeiculo(7); m1.setMarcaVeiculo("Haojue");
 * m1.setPlacaVeiculo("KSN6325"); m1.setVelocidadeVeiculo(550);
 * 
 * Moto m2 = new Moto(); m2.setId(id++); m2.setCilindradaMoto(600);
 * m2.setMarchaVeiculo(5); m2.setMarcaVeiculo("Suzuki");
 * m2.setPlacaVeiculo("XML2774"); m2.setVelocidadeVeiculo(350);
 * 
 * //atributo da classe lista.add(m1); lista.add(m2); }
 * 
 * public void adiciona(Moto moto) { moto.setId(MotoDao.id++);
 * MotoDao.lista.add(moto); }
 * 
 * public List<Moto> getMotos(){ //atributo de classe return MotoDao.lista; }
 * 
 * public List<Moto> buscaMoto(String campoPesquisa) { ArrayList<Moto> lista =
 * new ArrayList<>(); Moto motoBuscada = new Moto(); motoBuscada.setId(id++);
 * motoBuscada.setCilindradaMoto(1000); motoBuscada.setMarcaVeiculo("5");
 * motoBuscada.setMarcaVeiculo("Benelli");
 * motoBuscada.setPlacaVeiculo("ITL2021");
 * motoBuscada.setVelocidadeVeiculo(450);
 * 
 * lista.add(motoBuscada); return lista;
 * 
 * }
 * 
 * 
 * public void removeMoto(Integer id) { Iterator<Moto> it = lista.iterator();
 * while(it.hasNext()) { Moto moto = it.next();
 * 
 * if(moto.getId() == id) { it.remove(); } } }
 * 
 * public Moto buscaMotoPorId(Integer id) { for(Moto moto : lista) {
 * if(moto.getId() == id) { return moto; } }
 * 
 * //deixar retornando null, mas deveria tratar a exceção caso o ID não exista
 * //supondo que o id passado sempre irá existir return null; }
 */
