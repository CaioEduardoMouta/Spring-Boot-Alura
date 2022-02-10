package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	
	public String gerarToken(Authentication authentication) {
		Usuario logado =  (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date (hoje.getTime() + Long.parseLong(expiration));
		
		
		return Jwts.builder().setIssuer("API do Forum da Alura")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret )
				.compact();
	}

}
