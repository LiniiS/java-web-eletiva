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
 * Servlet implementation class ExibeMoto
 * apresenta os dados para edição
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/exibeMoto")
public class ExibeMoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String motoId = request.getParameter("id");
		Integer id = Integer.valueOf(motoId);

		MotoDao motoDao = new MotoDao();

		Moto moto = motoDao.buscaMotoPorId(id);

		request.setAttribute("moto", moto);

		// ------------------------------------------------> atentar para o path
		RequestDispatcher rd = request.getRequestDispatcher("/frota/moto/formAlteraMoto.jsp");
		rd.forward(request, response);
	}

}
