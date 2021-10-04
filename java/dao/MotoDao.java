package br.com.asantos.gerenciador.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.asantos.gerenciador.vo.Moto;

/**
 * Classe que simula um Banco de Dados para a classe Moto
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.1
 */
public class MotoDao {
	
	
	private static List<Moto> lista = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Moto m1 = new Moto();
		m1.setId(id++);
		m1.setCilindradaMoto(1500);
		m1.setMarchaVeiculo(7);
		m1.setMarcaVeiculo("Haojue");
		m1.setPlacaVeiculo("KSN6325");
		m1.setVelocidadeVeiculo(550);
		
		Moto m2 = new Moto();
		m2.setId(id++);
		m2.setCilindradaMoto(600);
		m2.setMarchaVeiculo(5);
		m2.setMarcaVeiculo("Suzuki");
		m2.setPlacaVeiculo("XML2774");
		m2.setVelocidadeVeiculo(350);
		
		//atributo da classe
		lista.add(m1);
		lista.add(m2);
	}
	
	public void adiciona(Moto moto) {
		moto.setId(MotoDao.id++);
		MotoDao.lista.add(moto);
	}
	
	public List<Moto> getMotos(){
		//atributo de classe
		return MotoDao.lista;
	}
	
	public List<Moto> buscaMoto(String campoPesquisa) {
		ArrayList<Moto> lista = new ArrayList<>();
		Moto motoBuscada = new Moto();
		motoBuscada.setId(id++);
		motoBuscada.setCilindradaMoto(1000);
		motoBuscada.setMarcaVeiculo("5");
		motoBuscada.setMarcaVeiculo("Benelli");
		motoBuscada.setPlacaVeiculo("ITL2021");
		motoBuscada.setVelocidadeVeiculo(450);

		lista.add(motoBuscada);
		return lista;

	}
	
	
	public void removeMoto(Integer id) {
		Iterator<Moto> it = lista.iterator();
		while(it.hasNext()) {
			Moto moto = it.next();
			
			if(moto.getId() == id) {
				it.remove();
			}
		}
	}

	public Moto buscaMotoPorId(Integer id) {
		for(Moto moto : lista) {
			if(moto.getId() == id) {
				return moto;
			}
		}

		//deixar retornando null, mas deveria tratar a exceção caso o ID não exista
		//supondo que o id passado sempre irá existir
		return null;
	}
	
}
