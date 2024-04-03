package py.com.jwt.model.dto;

 

import lombok.AllArgsConstructor;
import lombok.Data;
import py.com.jwt.model.Usuario;

@Data
@AllArgsConstructor
public class JwtResponse {

	private final String jwttoken;
	private final Usuario usuario;

}
