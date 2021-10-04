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
 * Servlet implementation class NovoCarro
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/carros")
public class NovoCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaCarro = request.getParameter("marcaCarro");
		String placaCarro = request.getParameter("placaCarro");
		String velocidadeCarro = request.getParameter("velocidadeCarro");
		String marchaCarro = request.getParameter("marchaCarro");
		String portasCarro = request.getParameter("portasCarro");
		String arCarro = request.getParameter("arCarro");
		
		Carro c = new Carro();
		//verificar como que tá sendo parseado o Boolean que vem do switch no boostrap
		c.setArCarro(Boolean.parseBoolean(arCarro));
		c.setMarcaVeiculo(marcaCarro);
		c.setMarchaVeiculo(Integer.parseInt(marchaCarro));
		c.setPlacaVeiculo(placaCarro);
		//porta -> mudar o type pra number no form de cadastro
		c.setPortasCarro(portasCarro);
		c.setVelocidadeVeiculo(Integer.parseInt(velocidadeCarro));		
		
		//System.out.println(c.getMarcaVeiculo());
		
		CarroDao lst = new CarroDao();
		lst.adiciona(c);
		

		RequestDispatcher rd = request.getRequestDispatcher("frota/carro/novoCarroCadastrado.jsp");
		request.setAttribute("marcaCarro", c.getMarcaVeiculo());
		rd.forward(request, response);
	}

}
