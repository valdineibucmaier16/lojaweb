package br.edu.utfpr.pb.lojaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.lojaweb.model.Fornecedor;
import br.edu.utfpr.pb.lojaweb.repository.FornecedorRepository;
import br.edu.utfpr.pb.lojaweb.service.FornecedorService;

@Service
public class FornecedorServiceImp extends CrudServiceImpl<Fornecedor, Long> implements FornecedorService{

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	protected JpaRepository<Fornecedor, Long> getRepository() {
		
		return fornecedorRepository;
	}

}
