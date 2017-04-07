package br.com.app.iqoption.security;

import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import br.com.app.iqoption.config.Constante;

@Component
public class SimpleCORSFilter extends GenericFilterBean {

	private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

	public SimpleCORSFilter() {
		log.info("SimpleCORSFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Credentials", "true");
		res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, X-Requested-With");

		HttpServletRequest req = (HttpServletRequest) request;

		// if(req.getMethod().equalsIgnoreCase("/OPTIONS/")){
		// chain.doFilter(request, response);
		// }

//		if (!req.getRequestURI().contains("/login/")) {
		if (true){
			String header = req.getHeader("Autorization");

			if (header == null || !header.startsWith("Bearer ")) {
				throw new ServerException("Token inválido.");
			}
			String token = header.substring(7);

			try {
				Jwts.parser().setSigningKey(Constante.KEY_CRIPT).parseClaimsJwt(token).getBody();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		chain.doFilter(request, response);
	}

}