package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticaoController {
	
	@Autowired
	private AuthenticationManager authManager; 
	
	@Autowired
	private TokenService tokenSerice;
	
	@PostMapping
	public ResponseEntity<?> aunteticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = TokenService.gerarToken(authentication);
			return ResponseEntity.ok().build();
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	
	
	}

}
