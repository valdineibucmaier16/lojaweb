package br.edu.utfpr.pb.lojaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Assunto;
import br.edu.utfpr.pb.lojaweb.repository.AssuntoRepository;
import br.edu.utfpr.pb.lojaweb.service.AssuntoService;

@Service
public class AssuntoServiceImpl extends CrudServiceImpl<Assunto, Long> implements AssuntoService {

	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Override
	protected JpaRepository<Assunto, Long> getRepository() {
		return assuntoRepository;
	}

}
