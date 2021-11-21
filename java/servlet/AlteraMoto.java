package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.MotoDao;
import br.com.asantos.gerenciador.vo.Moto;

/**
 * Servlet implementation class AlteraMoto as alterações dos dados já
 * cadastrados serão mapeadas por este servlet
 * 
 * @author Aline S
 * @version 0.2
 */
@WebServlet("/alteraMoto")
public class AlteraMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String motoId = request.getParameter("id");
		Integer id = Integer.valueOf(motoId);

		String marcaMoto = request.getParameter("marcaMoto");
		String placaMoto = request.getParameter("placaMoto");
		String velocidadeMoto = request.getParameter("velocidadeMoto");
		String marchaMoto = request.getParameter("marchaMoto");
		String cilindradaMoto = request.getParameter("cilindradaMoto");

		MotoDao motoDao = new MotoDao();
		Moto m = new Moto();
		try {
			m = motoDao.findByIdMoto(id);

			m.setMarcaVeiculo(marcaMoto);
			m.setPlacaVeiculo(placaMoto);
			m.setVelocidadeVeiculo(Integer.parseInt(velocidadeMoto));
			m.setMarchaVeiculo(Integer.parseInt(marchaMoto));
			m.setCilindradaMoto(Integer.parseInt(cilindradaMoto));

			motoDao.editMoto(m);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// -------------------> atentar para o path!
		response.sendRedirect("frota/moto/editarMotoSucesso.jsp");

	}

}
