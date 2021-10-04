package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;

/**
 * Servlet implementation class RemoveCliente
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/removeCliente")
public class RemoveCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//mais adequado seria um Delete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clientId = request.getParameter("id");
		Integer id = Integer.valueOf(clientId);
		
		ClienteDao clientes = new ClienteDao();
		clientes.removeCliente(id);
	
		response.sendRedirect("listaClientes");
	}

}
