package br.com.asantos.gerenciador.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Classe que simula um Banco de Dados para a classe Terreno
 * contem uma lista pré-pronta dos itens e
 * possui ações típicas de um BD
 * 
 * @author Aline S
 * @version 0.1
 */
public class TerrenoDao {

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

}
