package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CarroDao;
import br.com.asantos.gerenciador.vo.Carro;

/**
 * Servlet implementation class RemoveCarro
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/removeCarro")
public class RemoveCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//mais adequado seria um doDelete
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carroId = request.getParameter("id");
		Integer id = Integer.valueOf(carroId);
		
		CarroDao carroDao = new CarroDao();
		Carro carro = new Carro();
		carro.setId(id);
		try {
			carroDao.deleteCarro(carro);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		response.sendRedirect("listaCarros");

		
	}

}
