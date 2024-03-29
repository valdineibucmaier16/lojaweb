package br.edu.utfpr.pb.lojaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Livro;
import br.edu.utfpr.pb.lojaweb.repository.LivroRepository;
import br.edu.utfpr.pb.lojaweb.service.LivroService;

@Service
public class LivroServiceImpl extends CrudServiceImpl<Livro, Long> implements LivroService{

	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	protected JpaRepository<Livro, Long> getRepository() {
		return livroRepository;
	}

	
}
