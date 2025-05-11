package com.hcl.demo.filter;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;

public class RouteValidator {

	  public static final List<String> openApiEndpoints = List.of(
	            "/auth/register",
	            "/auth/token",
	            "/eureka"
	    );

	    public Predicate<ServerHttpRequest> isSecured =
	            request -> openApiEndpoints
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
