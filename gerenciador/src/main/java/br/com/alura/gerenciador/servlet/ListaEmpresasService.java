package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class ListaEmpresasService
 */
@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = new Banco().geEmpresas();
		
		Gson gson = new Gson();
		String json = gson.toJson(empresas);
		
		
		response.setContentType("text/html");
		response.getWriter().print(json);
	}

}
