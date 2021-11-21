package br.com.asantos.gerenciador.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.asantos.gerenciador.vo.Carro;
/**
 * Classe que simula um Banco de Dados para a classe Carro
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.2
 */
public class CarroDao extends BaseDao {

public ArrayList<Carro> getCarros() throws Exception{
	open();
	ArrayList<Carro> lst = new ArrayList<>();
	
	Statement stm = getConn().createStatement();
	String sql = "SELECT car_id, car_marca, car_placa, car_portas FROM carro";
	
	ResultSet rs = stm.executeQuery(sql);
	while(rs.next()) {
		Carro car = new Carro();
		car.setId(rs.getInt(1));
		car.setMarcaVeiculo(rs.getString(2));
		car.setPlacaVeiculo(rs.getString(3));
		car.setPortasCarro(rs.getString(4));
		lst.add(car);
	}
	stm.close();
	rs.close();
	return lst;
}
	
public ArrayList<Carro> findCarros(String marca) throws Exception{
	super.open();
	ArrayList<Carro> lst = new ArrayList<>();
	String sql = "SELECT car_id, car_marca, car_placa, car_portas FROM carro where car_marca like ?";
	PreparedStatement pstm = getConn().prepareStatement(sql);
	//vai concatenar um wildcard % ao nome, qlqr match cm o digitado será apresentado
	pstm.setString(1, marca + '%');
	
	ResultSet rs = pstm.executeQuery();
	while(rs.next()) {
		Carro car = new Carro();
		car.setId(Integer.parseInt(rs.getString(1)));
		car.setMarcaVeiculo(rs.getString(2));
		car.setPlacaVeiculo(rs.getString(3));
		//TODO ajustar dps, no VO e form está como string por questões didáticas
		//no bd tá CHAR 1
		car.setPortasCarro(rs.getString(4));
		//car.setVelocidadeVeiculo(Integer.parseInt(rs.getString(4)));
		
		lst.add(car);
	}
	pstm.close();
	rs.close();
	close();
	return lst;
	
}	
public void newCarro(Carro carro) throws Exception{
	open();
	//                                       1         2          3           4             5           6
	String query = "INSERT INTO carro (car_marca, car_marcha, car_placa, car_velocidade, car_portas, car_ar) values (?,?,?,?,?,?)";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setString(1, carro.getMarcaVeiculo());
	pstm.setInt(2, carro.getMarchaVeiculo());
	pstm.setString(3, carro.getPlacaVeiculo());
	pstm.setInt(4, carro.getVelocidadeVeiculo());
	pstm.setString(5, carro.getPortasCarro());
	//TODO verificar o parseamento do boolean, on/off button no form, boolean no VO
	//não tá salvando true/false no BD conforme vem do form, tá considerando valor default=0
	pstm.setBoolean(6, carro.isArCarro());
	pstm.execute();
	close();
}

public void editCarro(Carro carro) throws Exception {
	open();
	String query = "UPDATE carro set car_marca=?, car_marcha=?, car_placa=?, car_velocidade=?, car_portas=?, car_ar=? where car_id=?";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setString(1, carro.getMarcaVeiculo());
	pstm.setInt(2, carro.getMarchaVeiculo());
	pstm.setString(3, carro.getPlacaVeiculo());
	pstm.setInt(4, carro.getVelocidadeVeiculo());
	pstm.setString(5, carro.getPortasCarro());
	
	pstm.setBoolean(6, carro.isArCarro());
	pstm.setInt(7, carro.getId());
	pstm.execute();
	close();
}

public void deleteCarro(Carro carro) throws Exception{
	open();
	String query = "DELETE FROM carro where car_id=?";
	PreparedStatement pstm = getConn().prepareStatement(query);
	pstm.setInt(1, carro.getId());
	pstm.execute();
	pstm.close();
	close();
}


public Carro findByIdCarro(int id) throws Exception{
	super.open();
	//                       1        2          3         4          5                6           7                       8
	String sql = "SELECT car_id, car_marca, car_marcha, car_placa, car_velocidade, car_portas, car_ar FROM carro WHERE car_id=?";
	PreparedStatement pstm = getConn().prepareStatement(sql);
	pstm.setInt(1, id);
	
	ResultSet rs = pstm.executeQuery();
	Carro carro = new Carro();
	while(rs.next()) {
		carro.setId(Integer.parseInt(rs.getString(1)));
		carro.setMarcaVeiculo(rs.getString(2));
		carro.setMarchaVeiculo(Integer.parseInt(rs.getString(3)));
		carro.setPlacaVeiculo(rs.getString(4));
		carro.setVelocidadeVeiculo(Integer.parseInt(rs.getString(5)));
		carro.setPortasCarro(rs.getString(6));
		carro.setArCarro(Boolean.parseBoolean(rs.getString(7)));
		
		
	}
	
	rs.close();
	return carro;
}

	
}	
	/*
	private static List<Carro> lista = new ArrayList<>();
	private static Integer id = 1;

	static {
		Carro c1 = new Carro();
		c1.setId(id++);
		c1.setArCarro(true);
		c1.setMarcaVeiculo("Chery Tiggo");
		c1.setMarchaVeiculo(6);
		c1.setPlacaVeiculo("DKC7765");
		c1.setPortasCarro("4");
		c1.setVelocidadeVeiculo(320);

		Carro c2 = new Carro();
		c2.setId(id++);
		c2.setArCarro(false);
		c2.setMarcaVeiculo("Lifan");
		c2.setMarchaVeiculo(7);
		c2.setPlacaVeiculo("HMC4452");
		c2.setPortasCarro("7");
		c2.setVelocidadeVeiculo(450);

		lista.add(c1);
		lista.add(c2);
	}

	public void adiciona(Carro carro) {
		//settar o id assim que cadastrar um novo carro
		carro.setId(CarroDao.id++);
		CarroDao.lista.add(carro);
	}

	public List<Carro> getCarros() {
		// atributo de classe
		return CarroDao.lista;
	}

	public List<Carro> buscaCarro(String campoPesquisa) {
		ArrayList<Carro> lista = new ArrayList<>();
		Carro carroBuscado = new Carro();
		carroBuscado.setId(id++);
		carroBuscado.setArCarro(true);
		carroBuscado.setMarcaVeiculo("7");
		carroBuscado.setMarcaVeiculo("Mahindra");
		carroBuscado.setPlacaVeiculo("LNS1987");
		carroBuscado.setPortasCarro("5");
		carroBuscado.setVelocidadeVeiculo(450);

		lista.add(carroBuscado);
		return lista;

	}
	
	
	public void removeCarro(Integer id) {
		//método tradicional para iterar uma lista
		//mais comum em código legado
		//daria pra usar stream e =>
		Iterator<Carro> it = lista.iterator();
		
		while(it.hasNext()) {
			Carro carro = it.next();
			
			if(carro.getId() == id) {
				it.remove();
			}
		}
	}

	public Carro buscaCarroPorId(Integer id) {
		for(Carro carro : lista) {
			if(carro.getId() == id) {
				return carro;
			}
		}

		//deixar retornando null, mas deveria tratar a exceção caso o ID não exista
		//supondo que o id passado sempre irá existir
		//o risco de retornar um null sem tratar exceção é sabido 
		return null;
	}
	
*/

