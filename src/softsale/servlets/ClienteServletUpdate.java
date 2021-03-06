package softsale.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softsale.model.Cliente;
import softsale.model.Endereco;
import softsale.model.service.ClienteService;

@WebServlet("/clientes-update")
public class ClienteServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado);
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		
		Cliente cliente = new Cliente(id, nome, cpf, telefone, email, endereco);
		ClienteService service = new ClienteService();
		service.saveUpdate(cliente);
		
		response.sendRedirect("/SoftSale/clientes-list");
	}
}
