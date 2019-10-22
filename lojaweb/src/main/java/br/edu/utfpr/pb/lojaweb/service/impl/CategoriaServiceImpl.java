package br.edu.utfpr.pb.lojaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Categoria;
import br.edu.utfpr.pb.lojaweb.repository.CategoriaRepository;
import br.edu.utfpr.pb.lojaweb.service.CategoriaService;

@Service
public class CategoriaServiceImpl extends CrudServiceImpl<Categoria, Long> implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	protected JpaRepository<Categoria, Long> getRepository() {
		return categoriaRepository;
	}

}
