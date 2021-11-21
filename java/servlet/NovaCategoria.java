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
 * Servlet implementation class NovaCategoria
 */
@WebServlet("/categorias")
public class NovaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String nomeCategoria = req.getParameter("categoria");
		String codigoCategoria = req.getParameter("codigo");
		Categoria categoria = new Categoria();
		categoria.setNome(nomeCategoria);
		categoria.setCodigoCategoria(Integer.valueOf(codigoCategoria));
		
		CategoriaDao catDao = new CategoriaDao();
		try {
			catDao.newcategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		resp.sendRedirect("categoria/novaCategoriaCadastrada.jsp");
	}

}
