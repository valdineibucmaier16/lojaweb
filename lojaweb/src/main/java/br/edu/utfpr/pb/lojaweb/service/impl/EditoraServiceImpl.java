package br.edu.utfpr.pb.lojaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Editora;
import br.edu.utfpr.pb.lojaweb.repository.EditoraRepositoy;
import br.edu.utfpr.pb.lojaweb.service.EditoraService;

@Service
public class EditoraServiceImpl extends CrudServiceImpl<Editora, Long> implements EditoraService{

	@Autowired
	private EditoraRepositoy marcaRepository;

	@Override
	public List<Editora> findByNomeLike(String nome) {	
		return null;
	}

	@Override
	protected JpaRepository<Editora, Long> getRepository() {
		return marcaRepository;
	}
	
	
}
