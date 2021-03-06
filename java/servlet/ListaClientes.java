package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;

/**
 * Servlet implementation class ListaClientes
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/listaClientes")
public class ListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// utilizar o service para contornar o erro do form = method post e o doGet de
	// trazer a lista
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDao clienteDao = new ClienteDao();

	
		// referente ao Search
		String campoPesquisa = request.getParameter("pesquisa");

		// se o campo de pesquisa estiver em branco, traga a lista de clientes (j?
		// cadastrados)
		try {
			if (campoPesquisa == "" || campoPesquisa == null) {
				request.setAttribute("clientes", clienteDao.getClientes());
			} else {
				// se tiver algo no campo de pesquisa, pegar da req e enviar ao DAO
				request.setAttribute("clientes", clienteDao.findClientes(campoPesquisa));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// RequestDispatcher rd =
		// request.getRequestDispatcher("cliente/listaClientes.jsp");

		// vai redirecionar pra p?gina inicial dos Clientes (lista + busca + novo
		// cliente)
		RequestDispatcher rd = request.getRequestDispatcher("cliente/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
