package br.com.asantos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.CategoriaDao;
import br.com.asantos.gerenciador.vo.Categoria;

/**
 * Servlet implementation class ExibeCategoria
 */
@WebServlet("/exibeCategoria")
public class ExibeCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoriaId = request.getParameter("id");
		Integer id = Integer.valueOf(categoriaId);

		CategoriaDao categoriaDao = new CategoriaDao();
		
		
		
		Categoria categoria = new Categoria();
		try {
			categoria = categoriaDao.findByIdCategoria(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		//bota na requisição que será despachada os dados da ${categoria.id}
		request.setAttribute("categoria", categoria);
		
		//chama a jsp que traz os dados daquele id
		RequestDispatcher rd = request.getRequestDispatcher("/categoria/formAlteraCategoria.jsp");
		rd.forward(request, response);
	}

}
