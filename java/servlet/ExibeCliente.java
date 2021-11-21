package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;
import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Servlet implementation class ExibeCliente
 * apresenta os dados para edição
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/exibeCliente")
public class ExibeCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clientId = request.getParameter("id");
		Integer id = Integer.valueOf(clientId);

		ClienteDao clienteDao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		try {
			cliente = clienteDao.findByIdCliente(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//bota na requisição que será despachada os dados do  ${cliente.id}
		request.setAttribute("cliente", cliente);
		
		//chama a jsp que traz os dados daquele id
		RequestDispatcher rd = request.getRequestDispatcher("/cliente/formAlteraCliente.jsp");
		rd.forward(request, response);
	}

}
