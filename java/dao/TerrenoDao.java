package br.com.asantos.gerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Classe que simula um Banco de Dados para a classe Terreno
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.2
 */
public class TerrenoDao extends BaseDao {

	public ArrayList<Terreno> getTerrenos() throws Exception {
		//conecta ao BD
		open();
		ArrayList<Terreno> lst = new ArrayList<>();
		
		Statement stm = getConn().createStatement();
		
		//query para retornar os dados do terreno
		String sql = "SELECT trn_id, trn_longitude, trn_latitude, trn_cota_trn FROM terreno";
		//devolve um  cnjto de resultados será capturado
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			Terreno trn = new Terreno();
			trn.setId(rs.getInt(1));
			trn.setLongitude(rs.getString(2));
			trn.setLatitude(rs.getString(3));
			trn.setCotasTerreno(rs.getInt(4));
			
			lst.add(trn);
		}
		stm.close();
		rs.close();
		close();
		return lst;
	}
//campo de pesquisa na página /listaTerrenos ~index.jsp	
public ArrayList<Terreno> findTerrenos(String nome) throws Exception{
	super.open();
	ArrayList<Terreno> lst = new ArrayList<>();
	String sql = "SELECT trn_id, trn_longitude, trn_latitude, trn_cota_trn FROM terreno where trn_cota_trn like ?";
	PreparedStatement pstm = getConn().prepareStatement(sql);
	//verificar se n vai quebrar aqui com o int sendo passado
	//vai pegar o parametro que tá no campo de busca e pede-se a busca por cotas, um int
	//adicionar a localidade ao VO pode ser mais interessante pra essa busca
	//TODO mudar o campo para pesquisar por outro atributo
	pstm.setString(1, nome + '%');
	ResultSet rs = pstm.executeQuery();
	while(rs.next()) {
		Terreno trn = new Terreno();
		trn.setId(rs.getInt(1));
		trn.setLongitude(rs.getString(2));
		trn.setLatitude(rs.getString(3));
		trn.setCotasTerreno(rs.getInt(4));
		
		lst.add(trn);
	}
	pstm.close();
	rs.close();
	close();
	return lst;
}
	
public void newTerreno(Terreno terreno) throws Exception{
	open();
	String query = " INSERT INTO terreno (trn_alt_max, trn_alt_min, trn_latitude, trn_longitude, trn_cota_trn, trn_qtde_trn) values (?,?,?,?,?,?)";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setString(1, terreno.getAlturaMax());
	pstm.setString(2, terreno.getAlturaMin());
	pstm.setString(3, terreno.getLatitude());
	pstm.setString(4, terreno.getLongitude());
	pstm.setInt(5, terreno.getCotasTerreno());
	pstm.setInt(6, terreno.getQtdeTerreno());
	
	pstm.execute();
	close();
	
}
	
public void editTerreno(Terreno terreno) throws Exception{
	open();
	//----------------------------------   1                 2            3               4                  5               6              7
	String query = " UPDATE terreno set trn_alt_max=?, trn_alt_min=?, trn_latitude=?, trn_longitude=?, trn_cota_trn=?, trn_qtde_trn=? where trn_id=?";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setString(1, terreno.getAlturaMax());
	pstm.setString(2, terreno.getAlturaMin());
	pstm.setString(3, terreno.getLatitude());
	pstm.setString(4, terreno.getLongitude());
	pstm.setInt(5, terreno.getCotasTerreno());
	pstm.setInt(6, terreno.getQtdeTerreno());
	pstm.setInt(7, terreno.getId());
	pstm.execute();
	
	close();
}
	
public void deleteTerreno(Terreno terreno) throws Exception{
	open();
	String query = "DELETE FROM terreno WHERE trn_id=?";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setInt(1, terreno.getId());
	pstm.execute();
	pstm.close();
	close();
}

public Terreno findByIdTerreno(int id) throws Exception{
	super.open();
	String sql = "SELECT trn_id, trn_longitude, trn_latitude, trn_cota_trn, trn_alt_max, trn_alt_min, trn_qtde_trn FROM terreno where trn_id=?";
	PreparedStatement pstm = getConn().prepareStatement(sql);
	pstm.setInt(1, id);
	
	ResultSet rs = pstm.executeQuery();
	Terreno terreno = new Terreno();
	while(rs.next()) {
		terreno.setId(Integer.parseInt(rs.getString(1)));
		terreno.setLongitude(rs.getString(2));
		terreno.setLatitude(rs.getString(3));
		terreno.setCotasTerreno(Integer.parseInt(rs.getString(4)));
		terreno.setAlturaMax(rs.getString(5));
		terreno.setAlturaMin(rs.getString(6));
		terreno.setQtdeTerreno(Integer.parseInt(rs.getString(7)));
	}
	rs.close();
	return terreno;
}
	
	
	
	
	
	
	
	
	
	
	
	
}	
	/*
	private static List<Terreno> lista = new ArrayList<>();
	private static Integer id = 1;

	static {
		Terreno t1 = new Terreno();
		t1.setId(id++);
		t1.setAlturaMax("400");
		t1.setAlturaMin("100");
		t1.setCotasTerreno(5);
		t1.setLatitude("41,40338");
		t1.setLongitude("2,17403");
		t1.setQtdeTerreno(10);

		Terreno t2 = new Terreno();
		t2.setId(id++);
		t2.setAlturaMax("1300");
		t2.setAlturaMin("500");
		t2.setCotasTerreno(2);
		t2.setLatitude("-15.7899");
		t2.setLongitude("-47.9038");
		t2.setQtdeTerreno(2);
		lista.add(t1);
		lista.add(t2);
	}

	public void adiciona(Terreno terreno) {
		terreno.setId(id++);
		TerrenoDao.lista.add(terreno);
	}

	public List<Terreno> getTerrenos() {
		return TerrenoDao.lista;
	}

	public ArrayList<Terreno> buscaTerreno(String terrenoPesquisado) {

		ArrayList<Terreno> lista = new ArrayList<>();
		Terreno terrenoBuscado = new Terreno();
		terrenoBuscado.setId(id++);
		terrenoBuscado.setCotasTerreno(14);
		terrenoBuscado.setLatitude("-10.7899");
		terrenoBuscado.setLongitude("-42.9038");
		lista.add(terrenoBuscado);

		return lista;

	}

	public void removeTerreno(Integer id) {

		Iterator<Terreno> it = lista.iterator();

		while (it.hasNext()) {
			Terreno terreno = it.next();

			if (terreno.getId() == id) {
				it.remove();
			}
		}

	}

	public Terreno buscaTerrenoPorId(Integer id2) {

		for (Terreno terreno : lista) {
			if (terreno.getId() == id2) {
				return terreno;
			}
		}

		return null;
	}
*/

