package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;
import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Servlet implementation class RemoveCliente
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.2
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
		
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente.setId(id);
		
		try {
			clienteDao.deleteCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		response.sendRedirect("listaClientes");
	}

}
