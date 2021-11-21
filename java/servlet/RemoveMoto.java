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
 * Servlet implementation class RemoveMoto representa a requisição de delete do
 * item cadastrado
 * 
 * @author Aline S
 * @version 0.2
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
		Moto moto = new Moto();
		moto.setId(id);

		try {
			motoDao.deleteMoto(moto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("listaMotos");

	}

}
