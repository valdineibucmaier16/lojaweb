package br.edu.utfpr.pb.lojaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.lojaweb.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
