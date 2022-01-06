import java.sql.Connection;

import java.sql.SQLException;


import modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("C�moda","C�moda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvarProduto(comoda);
		}
	}

}
