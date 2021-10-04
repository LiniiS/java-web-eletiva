package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.MotoDao;

/**
 * Servlet implementation class RemoveMoto
 * representa a requisição de delete do item cadastrado
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/removeMoto")
public class RemoveMoto extends HttpServlet {
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
		// vai percorrer a lista de motos (via iterator) e remover
		motoDao.removeMoto(id);

		response.sendRedirect("listaMotos");

	}

}
