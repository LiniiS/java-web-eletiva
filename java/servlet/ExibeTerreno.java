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
 * Servlet implementation class ExibeTerreno
 * apresenta os dados para edição
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/exibeTerreno")
public class ExibeTerreno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		TerrenoDao terrenos = new TerrenoDao();
		

		Terreno terreno = terrenos.buscaTerrenoPorId(id);
		
		request.setAttribute("terreno", terreno);
		
		RequestDispatcher rd = request.getRequestDispatcher("/terreno/formAlteraTerreno.jsp");
		rd.forward(request, response);
	
	
	
	}
}
