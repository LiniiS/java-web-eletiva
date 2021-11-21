package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CarroDao;

/**
 * Servlet implementation class ListaCarros
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/listaCarros")
public class ListaCarros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarroDao carroDao = new CarroDao();
		String campoPesquisa = request.getParameter("pesquisa");
		
		try {
			if (campoPesquisa == "" || campoPesquisa == null) {
				request.setAttribute("carros", carroDao.getCarros());
			} else {
				request.setAttribute("carros", carroDao.findCarros(campoPesquisa));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		RequestDispatcher rd = request.getRequestDispatcher("frota/carro/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
