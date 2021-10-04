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
 * Servlet implementation class AlteraCarro 
 * as alterações dos dados já
 * cadastrados serão mapeadas por este servlet
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/alteraCarro")
public class AlteraCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carroId = request.getParameter("id");
		Integer id = Integer.valueOf(carroId);

		String marcaCarro = request.getParameter("marcaCarro");
		String placaCarro = request.getParameter("placaCarro");
		String velocidadeCarro = request.getParameter("velocidadeCarro");
		String marchaCarro = request.getParameter("marchaCarro");
		String portasCarro = request.getParameter("portasCarro");
		String arCarro = request.getParameter("arCarro");

		CarroDao carroDao = new CarroDao();

		Carro c = carroDao.buscaCarroPorId(id);

		c.setArCarro(Boolean.parseBoolean(arCarro));
		c.setMarcaVeiculo(marcaCarro);
		c.setMarchaVeiculo(Integer.parseInt(marchaCarro));
		c.setPlacaVeiculo(placaCarro);
		c.setPortasCarro(portasCarro);
		c.setVelocidadeVeiculo(Integer.parseInt(velocidadeCarro));
		
		response.sendRedirect("frota/carro/editarCarroSucesso.jsp");

	}

}
