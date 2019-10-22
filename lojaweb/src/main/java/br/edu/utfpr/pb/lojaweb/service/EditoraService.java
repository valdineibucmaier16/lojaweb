package br.edu.utfpr.pb.lojaweb.service;

import java.util.List;

import br.edu.utfpr.pb.lojaweb.model.Editora;

public interface EditoraService extends CrudService<Editora, Long> {

	List<Editora> findByNomeLike(String nome);
}
