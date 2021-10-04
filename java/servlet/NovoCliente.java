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
 * Servlet implementation class NovoCliente
 * apresenta o formulario para cadastro
 * @author Aline S
 * @version 0.1
 */
@WebServlet("/clientes")
public class NovoCliente extends HttpServlet{
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//leitura
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
		String dtNascimento = req.getParameter("dtNascimento");
		String logradouro = req.getParameter("logradouro");
		String complemento = req.getParameter("complemento");
		String bairro = req.getParameter("bairro");
		String cidade = req.getParameter("cidade");
		String estado = req.getParameter("estado");
		String cep = req.getParameter("cep");
		
	/**
	 * tratar o parâmetro da Data de Nascimento que vem como String da requisição parseando pra Date
	 * o Date do java util tá obsoleto, causou alguns conflitos e por enqto vai
	 * ser tratado como String ao longo do projeto 	
	 */
		
		//try & throw ~parsing
//		Date dataNascimento = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			dataNascimento = sdf.parse(dtNascimento);
//		} catch (ParseException e) {
//			throw new ServletException(e);
//		}
			
		Cliente c = new Cliente();
		
		//gerar um id aleatório por enquanto -> esse id deve vir do banco de dados, mas aqui tá 
		//provisoriamente na gambiarra
		//substituido pela chave sequencial (id) na classe ClienteDao
		//Random random = new Random();
	
		//população
		//c.setId(random.nextInt(10));
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
		
		ClienteDao lst = new ClienteDao();
		lst.adiciona(c);
		
		
		/**
		 * para evitar o redirecionamento server-side e a duplicação de reenvio de dados na hr do cadastro
		 * causado pela atualização e duplicação do envio da requisição na chamada do servlet que chama outro servlet,
		 * esse redirecionamento vai ser feito pelo navegador (client-side)
		 */
		
//		RequestDispatcher rd = req.getRequestDispatcher("/cliente/novoClienteCadastrado.jsp");
//			req.setAttribute("nome", c.getNome());
//			rd.forward(req, resp);
		
		
		resp.sendRedirect("cliente/novoClienteCadastrado.jsp");
	
	}
	

}
