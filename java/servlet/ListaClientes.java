package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;
import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Servlet implementation class ListaClientes
 * apresenta a lista de itens cadastrados e
 * campo de busca
 * @author Aline S
 * @version 0.1
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

		List<Cliente> lista = clienteDao.getClientes();

		// referente ao Search
		String campoPesquisa = request.getParameter("pesquisa");

		// se o campo de pesquisa estiver em branco, traga a lista de clientes (já
		// cadastrados)
		if (campoPesquisa == "" || campoPesquisa == null) {
			request.setAttribute("clientes", lista);
		} else {
			// se tiver algo no campo de pesquisa, pegar da req e enviar ao DAO
			request.setAttribute("clientes", clienteDao.buscaCliente(campoPesquisa));
		}

		// RequestDispatcher rd =
		// request.getRequestDispatcher("cliente/listaClientes.jsp");

		// vai redirecionar pra página inicial dos Clientes (lista + busca + novo
		// cliente)
		RequestDispatcher rd = request.getRequestDispatcher("cliente/index.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
