package py.com.jwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import py.com.jwt.model.Usuario;
import py.com.jwt.model.dto.JwtRequest;
import py.com.jwt.repository.UsuarioRepository;

@Service
@AllArgsConstructor
public class AuthenticationService {

	private final UsuarioRepository usuarioRepository;

	private final AuthenticationManager authenticationManager;

	public Usuario authenticate(JwtRequest authenticationRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		return usuarioRepository.findOneByLogin(authenticationRequest.getUsername()).orElseThrow();
	}
}
