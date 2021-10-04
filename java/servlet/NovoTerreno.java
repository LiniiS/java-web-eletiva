package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.TerrenoDao;
import br.com.asantos.gerenciador.vo.Terreno;

/**
 * Servlet implementation class NovoTerreno
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/terrenos")
public class NovoTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String alturaMax = request.getParameter("alturaMax");
		String alturaMin = request.getParameter("alturaMin");
		String cotasTerreno = request.getParameter("cotasTerreno");
		String qtdeTerreno = request.getParameter("qtdeTerreno");

		Terreno t = new Terreno();
		
		t.setLatitude(latitude);
		t.setLongitude(longitude);
		t.setAlturaMax(alturaMax);
		t.setAlturaMin(alturaMin);
		t.setCotasTerreno(Integer.parseInt(cotasTerreno));
		t.setQtdeTerreno(Integer.parseInt(qtdeTerreno));
		
		TerrenoDao lst = new TerrenoDao();
		lst.adiciona(t);
		

		RequestDispatcher rd = request.getRequestDispatcher("/novoTerrenoCadastrado.jsp");
		request.setAttribute("cotasTerreno", t.getCotasTerreno());
		rd.forward(request, response);

	}

}
