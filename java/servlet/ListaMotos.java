package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.MotoDao;
import br.com.asantos.gerenciador.vo.Moto;

/**
 * Servlet implementation class ListaMotos
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/listaMotos")
public class ListaMotos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MotoDao motoDao = new MotoDao();
		List<Moto> lista = motoDao.getMotos();
		
		String campoPesquisa = request.getParameter("pesquisa");
		if(campoPesquisa =="" || campoPesquisa== null) {
			request.setAttribute("motos", lista);
			
		}else {
			request.setAttribute("motos", motoDao.buscaMoto(campoPesquisa));
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("frota/moto/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
