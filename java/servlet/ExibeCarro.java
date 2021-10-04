package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CarroDao;
import br.com.asantos.gerenciador.vo.Carro;

/**
 * Servlet implementation class ExibeCarro
 * apresenta os dados para edição
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/exibeCarro")
public class ExibeCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//parseia o Id do carro selecionado no "editar"
		String carroId = request.getParameter("id");
		Integer id = Integer.valueOf(carroId);
		
		//solicita o bd (simulado pela classe DAO)
		CarroDao carroDao = new CarroDao();
		
		//opera como a interface do CrudRepository/findById
		Carro carro = carroDao.buscaCarroPorId(id);
		
		//para pra requisição q será despachada pro front os atributos do objeto a ser exibido pra alteração
		request.setAttribute("carro", carro);
		
		//------------------------------------------------> atentar para o path
		RequestDispatcher rd = request.getRequestDispatcher("/frota/carro/formAlteraCarro.jsp");
		rd.forward(request, response);
		
	}

}
