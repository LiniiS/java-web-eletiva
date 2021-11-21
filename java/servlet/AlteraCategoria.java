package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CategoriaDao;
import br.com.asantos.gerenciador.vo.Categoria;

/**
 * Servlet implementation class AlteraCategoria
 */
@WebServlet("/alteraCategoria")
public class AlteraCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// leitura
		String nomeCategoria = request.getParameter("categoria");
		String codigoCategoria = request.getParameter("codigo");

		String idCategoria = request.getParameter("id");
		
		// verificar asap
		Integer id = Integer.valueOf(idCategoria);

		// busca na lista qual é o objeto daquele id pra exibir e repopular onde for
		// necessário
		Categoria categoria = new Categoria();
		CategoriaDao categoriaDao = new CategoriaDao();
		try {
			//busca no banco os dados do item selecionado
			categoria = categoriaDao.findByIdCategoria(id);
			//atribui aos campos exibidos na tela os valores (atuais ou alterados)
			categoria.setNome(nomeCategoria);
			categoria.setCodigoCategoria(Integer.valueOf(codigoCategoria));
			//chama o edit pra fazer o update nos valores que estão no banco
			categoriaDao.editCategoria(categoria);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		response.sendRedirect("categoria/novaCategoriaCadastrada.jsp");
	}
}
