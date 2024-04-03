package py.com.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import py.com.jwt.model.Usuario;
import py.com.jwt.model.dto.JwtRequest;
import py.com.jwt.model.dto.JwtResponse;
import py.com.jwt.service.AuthenticationService;
import py.com.jwt.service.JwtService;

@RestController
@CrossOrigin
@RequestMapping({ "/api/auth" })
@AllArgsConstructor
public class AuthController {

	private final JwtService jwtService;

	private final AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws Exception {

		Usuario authenticatedUser = authenticationService.authenticate(authenticationRequest);

		String jwtToken = jwtService.generateToken(authenticatedUser);

		return ResponseEntity.ok(new JwtResponse(jwtToken, authenticatedUser));
	}

}
