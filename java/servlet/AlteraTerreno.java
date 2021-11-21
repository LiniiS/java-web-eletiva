package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;
import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Servlet implementation class AlteraTerreno
 * as alterações dos dados já
 * cadastrados serão mapeadas por este servlet
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/alteraTerreno")
public class AlteraTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//leitura da requisição
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String alturaMax = request.getParameter("alturaMax");
		String alturaMin = request.getParameter("alturaMin");
		String cotasTerreno = request.getParameter("cotasTerreno");
		String qtdeTerreno = request.getParameter("qtdeTerreno");

		String terrenoId = request.getParameter("id");
		Integer id =Integer.valueOf(terrenoId);
		
		Terreno t = new Terreno();
		TerrenoDao terrenoDao = new TerrenoDao();
		try {
			//tenta buscar esse terreno q vem da requisição
			t = terrenoDao.findByIdTerreno(id);
			
			//tenta setar os dados:
			t.setLatitude(latitude);
			t.setLongitude(longitude);
			t.setAlturaMax(alturaMax);
			t.setAlturaMin(alturaMin);
			t.setCotasTerreno(Integer.parseInt(cotasTerreno));
			t.setQtdeTerreno(Integer.parseInt(qtdeTerreno));
			
			//chama o edit que executa a query de update no bd
			terrenoDao.editTerreno(t);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		response.sendRedirect("terreno/novoTerrenoCadastrado.jsp");
		
		
	}

}
