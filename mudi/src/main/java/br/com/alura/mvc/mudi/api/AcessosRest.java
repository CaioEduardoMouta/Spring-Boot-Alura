package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.InterceptadorDeAcessos;
import br.com.alura.mvc.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("acessos")
@RestController
public class AcessosRest {

	public List<Acesso> getAcessos() {
		return InterceptadorDeAcessos.acessos;
	}
}
