package br.com.asantos.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.asantos.gerenciador.dao.ClienteDao;
import br.com.asantos.gerenciador.vo.Cliente;

/**
 * Servlet implementation class AlteraCliente 
 * as altera��es dos dados j�
 * cadastrados ser�o mapeadas por este servlet
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/alteraCliente")
public class AlteraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// leitura
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String dtNascimento = request.getParameter("dtNascimento");
		String logradouro = request.getParameter("logradouro");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cep = request.getParameter("cep");

		String clientId = request.getParameter("id");
		//o campo de ID no form de altera��o s� funcionou ao se manter hidden
		Integer id = Integer.valueOf(clientId);

		System.out.println(id);
		/*
		  tratar o par�metro da Data de Nascimento que vem como String da requisi��o
		  parseando pra Date o Date do java util t� obsoleto, causou alguns conflitos e
		  por enqto vai ser tratado como String ao longo do projeto
		 */

		// try & throw ~parsing
//		Date dataNascimento = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			dataNascimento = sdf.parse(dtNascimento);
//		} catch (ParseException e) {
//			throw new ServletException(e);
//		}

		ClienteDao clienteDao = new ClienteDao();
		//a l�gica sera diferente pois a classe ClienteDao simula o banco de dados
		Cliente c = clienteDao.buscaClientePorId(id);
			
		c.setNome(nome);
		c.setSobrenome(sobrenome);
		c.setEmail(email);
		c.setTelefone(telefone);
		c.setDtNascimento(dtNascimento);
		c.setLogradouro(logradouro);
		c.setComplemento(complemento);
		c.setBairro(bairro);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setCEP(cep);

		System.out.println(c.getNome());
		/*
			por enquanto vai redirecionar pro mesmo servlet de sucesso de novo cadastro
			ou redireciona pra listaClientes e retorna a lista inicial
			ou cria um novo servlet com mensagens mais coerentes
			ou cria uma l�gica dentro deste servlet para analisar se � novo cadastro ou altera��o
			e dinamicamente colocar uma msg ou outra - daria pra usar o id pois ele s� t� presente 
			na requisi��o do alteraCadastro
		 */		
		response.sendRedirect("cliente/novoClienteCadastrado.jsp");

	}

}
