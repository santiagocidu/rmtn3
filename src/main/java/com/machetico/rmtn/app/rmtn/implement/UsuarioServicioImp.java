package com.machetico.rmtn.app.rmtn.implement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.machetico.rmtn.app.rmtn.dto.UsuarioRegistroDTO;
import com.machetico.rmtn.app.rmtn.model.Rol;
import com.machetico.rmtn.app.rmtn.model.Usuario;
import com.machetico.rmtn.app.rmtn.repository.UsuarioRepositoriio;
import com.machetico.rmtn.app.rmtn.service.UsuarioServicio;

@Service
public class UsuarioServicioImp implements UsuarioServicio {

	@Autowired
	private UsuarioRepositoriio usuarioRepositorio;

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre_com(), registroDTO.getCorreo(),
				(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByCorreo(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o Contraseña incorrectos");
		}
		return new User(usuario.getCorreo(), usuario.getPassword(),
				mapearAutoridadesARol(usuario.getRol()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesARol(Rol roles) {

		SimpleGrantedAuthority autoridad = new SimpleGrantedAuthority(roles.getNombre_rol());

		return Collections.singletonList(autoridad);

	}

}
