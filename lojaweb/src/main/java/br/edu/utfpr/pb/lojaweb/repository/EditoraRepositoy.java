package br.edu.utfpr.pb.lojaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.lojaweb.model.Editora;


public interface EditoraRepositoy extends JpaRepository<Editora, Long>{

	List<Editora> findByNomeLike(String nome);
}
