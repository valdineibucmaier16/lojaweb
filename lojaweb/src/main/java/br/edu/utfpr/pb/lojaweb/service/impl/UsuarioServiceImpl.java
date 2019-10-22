package br.edu.utfpr.pb.lojaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Usuario;
import br.edu.utfpr.pb.lojaweb.repository.UsuarioRepository;
import br.edu.utfpr.pb.lojaweb.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService, UserDetailsService {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	protected JpaRepository<Usuario, Long> getRepository() {

		return usuarioRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}
	
	

}
