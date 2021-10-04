package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.MotoDao;
import br.com.asantos.gerenciador.vo.Moto;

/**
 * Servlet implementation class NovaMoto
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/motos")
public class NovaMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String marcaMoto = req.getParameter("marcaMoto");
		String placaMoto = req.getParameter("placaMoto");
		String velocidadeMoto = req.getParameter("velocidadeMoto");
		String marchaMoto = req.getParameter("marchaMoto");
		String cilindradaMoto = req.getParameter("cilindradaMoto");
		
		Moto m = new Moto();
		
		m.setMarcaVeiculo(marcaMoto);
		m.setPlacaVeiculo(placaMoto);
		m.setVelocidadeVeiculo(Integer.parseInt(velocidadeMoto));
		m.setMarchaVeiculo(Integer.parseInt(marchaMoto));
		m.setCilindradaMoto(Integer.parseInt(cilindradaMoto));
		
		
		MotoDao lst = new MotoDao();
		lst.adiciona(m);
		
		//---------------------------------------> por conflito de path cm o css criou-se
		//---------------> um novo servlet pra rotear a msg de sucesso e outras navegações
		RequestDispatcher rd = req.getRequestDispatcher("frota/moto/novaMotoCadastrada.jsp");
		rd.forward(req, resp);
		
		
	}

}
