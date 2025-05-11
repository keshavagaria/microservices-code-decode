package com.hcl.demo.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hcl.demo.util.JwtUtil;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	@Autowired
	private RouteValidator routeValidator;
	
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain)->{
			if(routeValidator.isSecured.test(exchange.getRequest())) {
				//headers contain token or not
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			if(authHeader!=null && authHeader.startsWith("Bearer ")) {
					authHeader =  authHeader.substring(7);
				}
			try {
				// REST call to auth service
				// restTemplate.getForObject("http://IDENTITY-SERVICE/validate?token="+authHeader, String.class);
				jwtUtil.validateToken(authHeader);
				}catch (Exception e) {
					System.out.println("Invalid Access");
					throw new RuntimeException("Invalid Access");
				}
			}
			return chain.filter(exchange);
		});
		
	}
	
	public static class Config {
		
	}
}
