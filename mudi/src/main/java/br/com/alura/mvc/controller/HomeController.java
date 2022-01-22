package br.com.alura.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Laptop da Maya");
		pedido.setUrlImagem("https://http2.mlstatic.com/D_NQ_NP_2X_652104-MLB44777043805_022021-F.webp");
		pedido.setUrlProduto("https://produto.mercadolivre.com.br/MLB-1784483637-laptop-infantil-frozen-2-disney-bilingue-brinde-_JM?vip_filters=shipping:fulfillment#position=6&search_layout=grid&type=item&tracking_id=3f11741c-7191-4ae1-9e38-420d5a07664e");
		pedido.setDescricao("uma descricao qualquer");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos",pedidos);
		return "home";
	}
	

}
