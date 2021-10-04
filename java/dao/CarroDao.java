package br.com.asantos.gerenciador.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.asantos.gerenciador.vo.Carro;
/**
 * Classe que simula um Banco de Dados para a classe Carro
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.1
 */
public class CarroDao {

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
	

}
