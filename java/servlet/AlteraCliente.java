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
 * as alterações dos dados já
 * cadastrados serão mapeadas por este servlet
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
		//o campo de ID no form de alteração só funcionou ao se manter hidden
		Integer id = Integer.valueOf(clientId);

		System.out.println(id);
		/*
		  tratar o parâmetro da Data de Nascimento que vem como String da requisição
		  parseando pra Date o Date do java util tá obsoleto, causou alguns conflitos e
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
		//a lógica sera diferente pois a classe ClienteDao simula o banco de dados
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
			ou cria uma lógica dentro deste servlet para analisar se é novo cadastro ou alteração
			e dinamicamente colocar uma msg ou outra - daria pra usar o id pois ele só tá presente 
			na requisição do alteraCadastro
		 */		
		response.sendRedirect("cliente/novoClienteCadastrado.jsp");

	}

}
