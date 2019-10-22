package br.edu.utfpr.pb.lojaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "editora")
@Data
@NoArgsConstructor // cria o construtor vazio pelo lombok
@AllArgsConstructor // cria o construtor com todos os parâmetros
@EqualsAndHashCode(of= {"id"})
@ToString
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "o campo 'nome' deve ser preenchido" )
	@Column(length = 254, nullable = false)
	private String nome;
	
}
