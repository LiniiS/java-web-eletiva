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
 * Servlet implementation class RemoveCategoria
 */
@WebServlet("/removeCategoria")
public class RemoveCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//mais adequado seria um doDelete
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String categoriaId = request.getParameter("id");
			Integer id = Integer.valueOf(categoriaId);
			
			Categoria categoria = new Categoria();
			categoria.setId(id);
			
			CategoriaDao categoriaDao = new CategoriaDao();
			try {
				categoriaDao.deleteCategoria(categoria);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			response.sendRedirect("listaCategorias");
			
			
			
			
		}
}
